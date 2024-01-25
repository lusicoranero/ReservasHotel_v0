package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.dominio.Huesped;
import org.iesalandalus.programacion.reservashotel.dominio.Reserva;
import org.iesalandalus.programacion.reservashotel.dominio.TipoHabitacion;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Reservas {
    private Reserva[] reservas;
    private int capacidad;
    private int tama�o;


    public Reservas(int capacidad) {
        this.capacidad = capacidad;
        this.tama�o = 0;
        this.reservas = new Reserva[capacidad];
    }

    private Reserva[] copiaProfundaReservas() {
        Reserva[] copiaProfunda = new Reserva[tama�o];
        System.arraycopy(reservas, 0, copiaProfunda, 0, tama�o);
        return copiaProfunda;
    }

    public Reserva[] get() {
        return copiaProfundaReservas();
    }

    public int getTamano() {
        return tama�o;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void insertar(Reserva reserva) {
        if (reserva != null && buscarIndice(reserva) == -1 && tama�o < capacidad) {
            reservas[tama�o] = reserva;
            tama�o++;
        }
    }

    private int buscarIndice(Reserva reserva) {
        for (int i = 0; i < tama�o; i++) {
            if (reservas[i].equals(reserva)) {
                return i;
            }
        }
        return -1;
    }

    private boolean tamanoSuperado(int indice) {
        return indice >= tama�o;
    }

    private boolean capacidadSuperada(int indice) {
        return indice >= capacidad;
    }

    public Reserva buscar(Reserva reserva) {
        for (int i = 0; i < tama�o; i++) {
            if (reservas[i].equals(reserva)) {
                return reservas[i];
            }
        }
        return null;
    }

    public void borrar(Reserva reserva) {
        int indice = buscarIndice(reserva);
        if (indice != -1) {
            desplazarUnaPosicionHaciaIzquierda(indice);
            tama�o--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        if (!tamanoSuperado(indice)) {
            for (int i = indice; i < tama�o - 1; i++) {
                reservas[i] = reservas[i + 1];
            }
            reservas[tama�o - 1] = null; // �ltimo elemento a null
        }
    }

    public Reserva[] getReservas(Huesped huesped) {
        Reserva[] resultado = new Reserva[tama�o];
        int contador = 0;

        for (int i = 0; i < tama�o; i++) {
            if (reservas[i].getHuesped().equals(huesped)) {
                resultado[contador] = reservas[i];
                contador++;
            }
        }

        return Arrays.copyOf(resultado, contador);
    }


    public Reserva[] getReservasFuturas(Habitacion habitacion) {
        Reserva[] resultado = new Reserva[tama�o];
        int contador = 0;

        Date hoy = new Date();

        for (int i = 0; i < tama�o; i++) {
            if (reservas[i].getHabitacion().equals(habitacion) && reservas[i].getFechaInicioReserva().isAfter(LocalDate.now()))
            {
                resultado[contador] = reservas[i];
                contador++;
            }
        }

        return Arrays.copyOf(resultado, contador);
    }
}