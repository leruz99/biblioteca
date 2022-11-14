package com.ceiba.biblioteca.utils;



import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public Utils() {
    }
    public static final int USUARIO_INVITADO = 3;

    public static String formatoFechaMaximaDeDevolucion(LocalDate fechaMaximaDevolucion){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaMaximaDevolucion.format(formatter);

    }

    public static LocalDate asignarFechaDevolucionDeAcuerdoAlTipoDeUsuario(int tipoUsuario) {

        LocalDate fechaMaximaDevolucion = LocalDate.now();
        int diasAgregados = 0;
        int diasAgregadosAfiliado = 10;
        int diasAgregadosEmpleadoBiblioteca = 8;
        int diasAgregadosInvitado = 7;
        switch (tipoUsuario){
            case 1:
                return calcularDiasTotalFechaMaximaDevolucion(fechaMaximaDevolucion, diasAgregados,
                        diasAgregadosAfiliado);
            case 2:
                return calcularDiasTotalFechaMaximaDevolucion(fechaMaximaDevolucion, diasAgregados,
                        diasAgregadosEmpleadoBiblioteca);
            case 3:
                return calcularDiasTotalFechaMaximaDevolucion(fechaMaximaDevolucion, diasAgregados,
                        diasAgregadosInvitado);
            default:
                return fechaMaximaDevolucion;
        }


    }
    private static LocalDate calcularDiasTotalFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion,
                                                             int diasAgregados, int diasAgregadosAfiliado) {
        while (diasAgregados < diasAgregadosAfiliado) {
            fechaMaximaDevolucion = fechaMaximaDevolucion.plusDays(1);
            if (!(fechaMaximaDevolucion.getDayOfWeek() == DayOfWeek.SATURDAY
                    || fechaMaximaDevolucion.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++diasAgregados;
            }
        }
        return fechaMaximaDevolucion;
    }

}
