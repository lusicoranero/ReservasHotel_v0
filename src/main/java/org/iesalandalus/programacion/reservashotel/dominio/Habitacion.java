package org.iesalandalus.programacion.reservashotel.dominio;

import java.util.Objects;

public class Habitacion {

    public final double MIN_PRECIO_HABITACION=40;
    public final double MAX_PRECIO_HABITACION=150;
    public final int MIN_NUMERO_PUERTA=1;
    public final int MAX_NUMERO_PUERTA=15;
    public final int MIN_NUMERO_PLANTA=1;
    public final int MAX_NUMERO_PLANTA=3;
    private String identificador=null;
    private int planta;
    private int puerta;
    private double precio;
    private TipoHabitacion tipoHabitacion;
    private String descripcion;

    public Habitacion( int planta, int puerta, double precio, String descripcion) {

        setPlanta();
        setPuerta(puerta);
        setIdentificador(identificador);
        setPrecio(precio);
        setDescripcion(descripcion);
    }

    public Habitacion( int planta, int puerta, double precio, TipoHabitacion tipoHabitacion, String descripcion){

        setPlanta();
        setPuerta(puerta);
        setIdentificador(identificador);
        setPrecio(precio);
        setTipoHabitacion(tipoHabitacion);
        setDescripcion(descripcion);
    }

    public Habitacion (Habitacion habitacion){
        this.identificador= habitacion.identificador;
        this.planta= habitacion.planta;
        this.puerta= habitacion.puerta;
        this.precio= habitacion.precio;
        this.tipoHabitacion=habitacion.tipoHabitacion;
        this.descripcion= habitacion.descripcion;
    }

    public String getIdentificador() {
        return identificador;
    }

    private void setIdentificador(String identificador) {
        identificador = String.valueOf(this.planta) + String.valueOf(this.puerta);
        this.identificador = identificador;
    }

    public int getPlanta() {
        return planta;
    }

    private void setPlanta() {
        if (planta>=MIN_NUMERO_PLANTA && planta <=MAX_NUMERO_PLANTA)
            this.planta = planta;
        else
            throw new IllegalArgumentException("La planta debe estar entre "+MIN_NUMERO_PLANTA+" y "+MAX_NUMERO_PLANTA);
    }

    public int getPuerta() {
        return puerta;
    }

    private void setPuerta(int puerta) {
        if(puerta>=MIN_NUMERO_PUERTA && puerta<=MAX_NUMERO_PUERTA)
            this.puerta = puerta;
        else
            throw new IllegalArgumentException("La puerta debe estar entre "+MIN_NUMERO_PUERTA+ " y "+MAX_NUMERO_PUERTA );
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if(precio>=MIN_PRECIO_HABITACION && precio <=MAX_PRECIO_HABITACION)
            this.precio = precio;
        else
            throw new IllegalArgumentException("El precio debe estar entre "+MIN_PRECIO_HABITACION+" y "+MAX_PRECIO_HABITACION );
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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