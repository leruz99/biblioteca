package com.ceiba.biblioteca.controller;


import com.ceiba.biblioteca.domain.dto.RespuestaPrestamo;
import com.ceiba.biblioteca.domain.dto.RespuestaSolicitud;
import com.ceiba.biblioteca.domain.dto.SolicitudPrestarLibroDto;
import com.ceiba.biblioteca.services.PrestamoService;
import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("prestamo")
public class PrestamoControlador {

    @Autowired
    public PrestamoService prestamoService;
    public PrestamoControlador(){

    }

    @PostMapping
    public ResponseEntity<RespuestaSolicitud> crearPrestamo(@Valid @RequestBody SolicitudPrestarLibroDto solicitu){
        RespuestaSolicitud respuestaSolicitud = prestamoService.crearPrestamo(solicitu);
        return new ResponseEntity<>(respuestaSolicitud, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<RespuestaPrestamo>> obtenerPrestamo(@PathVariable Long id){
        Optional<RespuestaPrestamo> respuestaPrestamo = prestamoService.obtenerPrestamoPorId(id);
        return new ResponseEntity<>(respuestaPrestamo, HttpStatus.OK);
    }


}

