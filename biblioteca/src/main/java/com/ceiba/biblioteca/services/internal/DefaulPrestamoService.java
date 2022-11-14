package com.ceiba.biblioteca.services.internal;

import com.ceiba.biblioteca.domain.dto.RespuestaPrestamo;
import com.ceiba.biblioteca.domain.dto.RespuestaSolicitud;
import com.ceiba.biblioteca.domain.dto.SolicitudPrestarLibroDto;
import com.ceiba.biblioteca.domain.model.SolicitudPrestamosLibro;
import com.ceiba.biblioteca.exceptions.UsuarioInvitadoMasDeUnPrestamoExcepcion;
import com.ceiba.biblioteca.infrastructure.jpa.repositories.PrestamoRepository;
import com.ceiba.biblioteca.mapper.PrestamoMapper;
import com.ceiba.biblioteca.services.PrestamoService;
import com.ceiba.biblioteca.utils.Utils;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class DefaulPrestamoService implements PrestamoService {


    private final PrestamoRepository prestamoRepository;

    public DefaulPrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @Override
    public RespuestaSolicitud crearPrestamo(SolicitudPrestarLibroDto solicitudPrestarLibroDto) {

        SolicitudPrestamosLibro solicitudPrestamosLibro = new SolicitudPrestamosLibro();
        RespuestaSolicitud respuestaSolicitud = new RespuestaSolicitud();

        if(!(prestamoRepository.existsByIdentificacionUsuario(solicitudPrestarLibroDto.getIdentificacionUsuario()))){
            return setearInformacionSolicitudPrestamosLibroYGuardarSolicitud(solicitudPrestarLibroDto, solicitudPrestamosLibro,respuestaSolicitud);
        }
        else if (prestamoRepository.existsByIdentificacionUsuario(solicitudPrestarLibroDto.getIdentificacionUsuario()) && solicitudPrestarLibroDto.getTipoUsuario() == Utils.USUARIO_INVITADO) {
            throw new UsuarioInvitadoMasDeUnPrestamoExcepcion(new StringBuilder().append(
                            "El usuario con identificación ").append(solicitudPrestarLibroDto.getIdentificacionUsuario())
                    .append(" ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo")
                    .toString());
        } else if (prestamoRepository.existsByIdentificacionUsuario(solicitudPrestarLibroDto.getIdentificacionUsuario()) && solicitudPrestarLibroDto.getTipoUsuario() != Utils.USUARIO_INVITADO) {
            return setearInformacionSolicitudPrestamosLibroYGuardarSolicitud(solicitudPrestarLibroDto, solicitudPrestamosLibro,respuestaSolicitud);

        }
        return respuestaSolicitud;
    }

    @Override
    public Optional<RespuestaPrestamo> obtenerPrestamoPorId(Long id) {

        Optional<SolicitudPrestamosLibro> solicitudPrestamosLibro = prestamoRepository.findById(id);
        if(solicitudPrestamosLibro.isPresent()){
            return Optional.of(PrestamoMapper.convertirSolicitudPrestarLibroARespuestaPrestamo(solicitudPrestamosLibro.get()));
        }

        return Optional.empty();
    }
    private RespuestaSolicitud setearInformacionSolicitudPrestamosLibroYGuardarSolicitud(SolicitudPrestarLibroDto solicitudPrestarLibroDto,
                                                                                         SolicitudPrestamosLibro solicitudPrestamosLibro,
                                                                                         RespuestaSolicitud respuestaSolicitud){
        solicitudPrestamosLibro.setFechaMaximaDevolucion(Utils.asignarFechaDevolucionDeAcuerdoAlTipoDeUsuario(solicitudPrestarLibroDto.getTipoUsuario()));
        solicitudPrestamosLibro.setIdentificacionUsuario(solicitudPrestarLibroDto.getIdentificacionUsuario());
        solicitudPrestamosLibro.setIsbn(solicitudPrestarLibroDto.getIsbn());
        solicitudPrestamosLibro.setTipoUsuario(solicitudPrestarLibroDto.getTipoUsuario());

        SolicitudPrestamosLibro solicitudPrestamosLibroEntity = prestamoRepository.save(solicitudPrestamosLibro);
        respuestaSolicitud.setFechaMaximaDevolucion(Utils.formatoFechaMaximaDeDevolucion(solicitudPrestamosLibroEntity.getFechaMaximaDevolucion()));
        respuestaSolicitud.setId(solicitudPrestamosLibroEntity.getId());

        return respuestaSolicitud;
    }
}
