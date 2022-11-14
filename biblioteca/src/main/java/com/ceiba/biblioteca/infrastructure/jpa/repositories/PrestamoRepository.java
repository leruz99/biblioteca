package com.ceiba.biblioteca.infrastructure.jpa.repositories;

import com.ceiba.biblioteca.domain.model.SolicitudPrestamosLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<SolicitudPrestamosLibro, Long> {
    boolean existsByIdentificacionUsuario(String identificacionUsuario);
}
