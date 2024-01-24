package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

    public final double MIN_PRECIO_HABITACION=40;
    public final double MAX_PRECIO_HABITACION=150;
    public final int MIN_NUMERO_PUERTA=1;
    public final int MAX_NUMERO_PUERTA=15;
    public final int MIN_NUMERO_PLANTA=1;
    public final int MAX_NUMERO_PLANTA=3;
    private String identificador;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;
    private String descripcion;

    public Habitacion( int planta, int puerta, double precio, String descripcion) {
        if (planta>=MIN_NUMERO_PLANTA && planta <=MAX_NUMERO_PLANTA)
            this.planta = planta;
        else
            throw new IllegalArgumentException("La planta debe estar entre 1 y 3");

        if(puerta>=MIN_NUMERO_PUERTA && puerta<=MAX_NUMERO_PUERTA)
            this.puerta = puerta;
        else
            throw new IllegalArgumentException("La puerta debe estar entre 1 y 15");

        identificador = String.valueOf(this.planta) + String.valueOf(this.puerta);

        if(precio>=MIN_PRECIO_HABITACION && precio <=MAX_PRECIO_HABITACION)
            this.precio = precio;

        this.descripcion = descripcion;
    }
    public Habitacion( int planta, int puerta, double precio, TipoHabitacion tipoHabitacion, String descripcion) {
        if (planta>=MIN_NUMERO_PLANTA && planta <=MAX_NUMERO_PLANTA)
            this.planta = planta;
        else
            throw new IllegalArgumentException("La planta debe estar entre 1 y 3");

        if(puerta>=MIN_NUMERO_PUERTA && puerta<=MAX_NUMERO_PUERTA)
            this.puerta = puerta;
        else
            throw new IllegalArgumentException("La puerta debe estar entre 1 y 15");

        identificador = String.valueOf(this.planta) + String.valueOf(this.puerta);

        if(precio>=MIN_PRECIO_HABITACION && precio <=MAX_PRECIO_HABITACION)
            this.precio = precio;

        this.tipoHabitacion = tipoHabitacion;
        this.descripcion = descripcion;
    }

    public Habitacion (Habitacion otraHabitacion){
        this.identificador= otraHabitacion.identificador;
        this.planta= otraHabitacion.planta;
        this.puerta= otraHabitacion.puerta;
        this.precio= otraHabitacion.precio;
        this.tipoHabitacion=otraHabitacion.tipoHabitacion;
        this.descripcion= otraHabitacion.descripcion;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(identificador, that.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }
}