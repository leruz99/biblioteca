package com.ceiba.biblioteca.exceptions;

public class ObjetoNulloExcepcion extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjetoNulloExcepcion(String mensaje){
        super(mensaje);
    }
}
