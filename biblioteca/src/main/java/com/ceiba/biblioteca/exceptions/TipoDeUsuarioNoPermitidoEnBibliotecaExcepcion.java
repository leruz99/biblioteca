package com.ceiba.biblioteca.exceptions;

public class TipoDeUsuarioNoPermitidoEnBibliotecaExcepcion extends RuntimeException{

    private static final long serialVersionUID = -1L;

    public TipoDeUsuarioNoPermitidoEnBibliotecaExcepcion(String mensaje){
        super(mensaje);
    }

}
