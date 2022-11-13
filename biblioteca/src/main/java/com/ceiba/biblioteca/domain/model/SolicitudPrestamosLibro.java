package com.ceiba.biblioteca.domain.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestamos_libro")
public class SolicitudPrestamosLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "isbn", columnDefinition = "VARCHAR(10)")
    private String isbn;
    @Column(name = "identificacion_usuario", columnDefinition = "VARCHAR(10)")
    private String identificacionUsuario;
    @Column(name = "tipo_usuario")
    private int tipoUsuario;
    @Column(name = "fecha_maxima_devolucion")
    private LocalDate fechaMaximaDevolucion;

    public SolicitudPrestamosLibro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getFechaMaximaDevolucion() {
        return fechaMaximaDevolucion;
    }

    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) {
        this.fechaMaximaDevolucion = fechaMaximaDevolucion;
    }
}
