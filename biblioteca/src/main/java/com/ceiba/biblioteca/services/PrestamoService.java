package com.ceiba.biblioteca.services;

import com.ceiba.biblioteca.domain.dto.RespuestaPrestamo;
import com.ceiba.biblioteca.domain.dto.RespuestaSolicitud;
import com.ceiba.biblioteca.domain.dto.SolicitudPrestarLibroDto;

import java.util.Optional;

public interface PrestamoService {

    RespuestaSolicitud crearPrestamo(SolicitudPrestarLibroDto solicitudPrestarLibroDto);
    Optional<RespuestaPrestamo> obtenerPrestamoPorId(Long id);
}
