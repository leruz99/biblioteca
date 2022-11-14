package com.ceiba.biblioteca.exceptions;

public class UsuarioInvitadoMasDeUnPrestamoExcepcion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UsuarioInvitadoMasDeUnPrestamoExcepcion(String mensaje){
        super(mensaje);
    }
}
