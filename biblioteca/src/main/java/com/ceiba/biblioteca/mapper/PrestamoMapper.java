package com.ceiba.biblioteca.mapper;

import com.ceiba.biblioteca.domain.dto.RespuestaPrestamo;
import com.ceiba.biblioteca.domain.model.SolicitudPrestamosLibro;
import com.ceiba.biblioteca.exceptions.ObjetoNulloExcepcion;
import com.ceiba.biblioteca.utils.Utils;


import java.util.Objects;
import java.util.logging.Logger;

public class PrestamoMapper {

    public static final Logger LOGGER = Logger.getLogger(PrestamoMapper.class.getName());

    public static RespuestaPrestamo convertirSolicitudPrestarLibroARespuestaPrestamo(SolicitudPrestamosLibro solicitudPrestamosLibro){
        RespuestaPrestamo respuestaPrestamo = new RespuestaPrestamo();
        if(Objects.isNull(solicitudPrestamosLibro)){
            throw new ObjetoNulloExcepcion("El objeto no puede ser nullo");
        }
        try{
            respuestaPrestamo.setId(solicitudPrestamosLibro.getId());
            respuestaPrestamo.setFechaMaximaDevolucion(Utils.formatoFechaMaximaDeDevolucion(solicitudPrestamosLibro.getFechaMaximaDevolucion()));
            respuestaPrestamo.setIdentificacionUsuario(solicitudPrestamosLibro.getIdentificacionUsuario());
            respuestaPrestamo.setIsbn(solicitudPrestamosLibro.getIsbn());
            respuestaPrestamo.setTipoUsuario(solicitudPrestamosLibro.getTipoUsuario());
            return respuestaPrestamo;

        }catch (Exception e){
            LOGGER.log(null, "convertirSolicitudPrestarLibroARespuestaPrestamo {}", e.getMessage());
        }
        return respuestaPrestamo;
    }
}
