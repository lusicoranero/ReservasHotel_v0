package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reserva {

    private final int MAX_NUMERO_MESES_RESERVA=2;
    private final int MAX_HORAS_POSTERIOR_CHECKOUT=12;
    public final String FORMATO_FECHA_RESERVA= "dd/MM/yyyy";
    private Huesped huesped;
    private Habitacion habitacion;
    private Regimen regimen;
    private LocalDate fechaInicioReserva;
    private LocalDate fechaFinReserva;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private double precio;
    private int numeroPersonas;




}
