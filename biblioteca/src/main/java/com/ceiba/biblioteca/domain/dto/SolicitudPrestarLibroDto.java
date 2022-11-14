package com.ceiba.biblioteca.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;

public class SolicitudPrestarLibroDto {

    @NotBlank(message = "El campo isbn no puede ser vacio")
    @Size(min = 1, max = 10, message = "El campo isbn supera el numero de caracteres permitido")
    @JsonProperty("isbn")
    private String isbn;

    @NotBlank(message = "El campo identificacionUsuario no puede ser vacio")
    @Size(min = 1, max = 10, message = "El campo identificacion de usurio supera el numero de caracteres permitidos")
    @JsonProperty("identificacionUsuario")
    private String identificacionUsuario;

    @Positive
    @Min(value = 1, message = "El tipo de usuario debe encontrarse entre  1 - 3")
    @Max(value = 3, message = "El tipo de usuario debe encontrarse entre 1 - 3")
    @JsonProperty("tipoUsuario")
    private int tipoUsuario;

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
}
