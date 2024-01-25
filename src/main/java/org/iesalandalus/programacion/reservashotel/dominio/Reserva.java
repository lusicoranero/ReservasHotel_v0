package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    public static final String FORMATO_FECHA_HORA_RESERVA ="yyyy-MM-dd HH:mm:ss";
    public static final int MAX_NUMERO_MESES_RESERVA=8;
    public static final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public static final String FORMATO_FECHA_RESERVA= "dd/MM/yyyy";
    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDateTime checkIn=null;
    private LocalDateTime checkOut=null;
    private double precio;
    private int numeroPersonas;

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public LocalDate getFechaInicioReserva() {
        return fechaInicioReserva;
    }

    public void setFechaInicioReserva(LocalDate fechaInicioReserva) {

        if(fechaInicioReserva.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de inicio de la reserva no puede ser anterior a la actual");

        if(LocalDate.now().plusMonths(MAX_NUMERO_MESES_RESERVA).isBefore(fechaInicioReserva))
            throw new IllegalArgumentException("No podemos reservar con mas de "+MAX_NUMERO_MESES_RESERVA+" meses de antelación");

        this.fechaInicioReserva = fechaInicioReserva;
    }

    public LocalDate getFechaFinReserva() {
        return fechaFinReserva;
    }

    public void setFechaFinReserva(LocalDate fechaFinReserva) {
        if(fechaFinReserva.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("La fecha de fin de la reserva no puede ser anterior a la actual");
        else
            this.fechaFinReserva = fechaFinReserva;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        if(numeroPersonas>getNumeroPersonas())
            throw new IllegalArgumentException("El número de personas no puede ser superior al tipo de habitación reservada");
        this.numeroPersonas = numeroPersonas;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {

        if(checkIn.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("El checkin no puede ser anterior a la hora actual");
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {

        if(checkOut.isBefore(checkIn))
            throw new IllegalArgumentException("El checkout no puede ser anterior al checkin");
        if(checkOut.isAfter(checkIn.plusHours(MAX_HORAS_POSTERIOR_CHECKOUT)))
            throw new IllegalArgumentException("El checkout debe ser como máximo a las 12");

        this.checkOut = checkOut;
    }

    public double getPrecio() {
        return precio;
    }

    private void setPrecio(double precio) {

        double precioBase=habitacion.getPrecio();
        double incrementoPorPersona=regimen.getIncrementoPrecio()*numeroPersonas;
        this.precio = precioBase+incrementoPorPersona;
    }

    public Reserva (Huesped huesped, Habitacion habitacion, Regimen regimen, LocalDate fechaInicioReserva, LocalDate fechaFinReserva, int numeroPersonas){

        setHuesped(huesped);
        setHabitacion(habitacion);
        setRegimen(regimen);
        setFechaInicioReserva(fechaInicioReserva);
        setFechaFinReserva(fechaFinReserva);
        setNumeroPersonas(numeroPersonas);

    }

    public Reserva (Reserva reserva){

        if (reserva==null)
            throw new IllegalArgumentException("ERROR: Una reserva no puede ser nula");

        this.huesped=reserva.huesped;
        this.habitacion=reserva.habitacion;
        this.regimen=reserva.regimen;
        this.fechaInicioReserva=reserva.fechaInicioReserva;
        this.fechaFinReserva=reserva.fechaFinReserva;
        this.numeroPersonas=reserva.numeroPersonas;

    }




}
