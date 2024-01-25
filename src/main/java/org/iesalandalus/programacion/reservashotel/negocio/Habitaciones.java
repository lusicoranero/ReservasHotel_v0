package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

public class Habitaciones {
    private Habitacion[] habitaciones;
    private int capacidad;
    private int tama�o;

    public Habitaciones(int capacidad) {
        this.capacidad = capacidad;
        this.tama�o = 0;
        this.habitaciones = new Habitacion[capacidad];
    }

    public Habitacion[] get() {
        Habitacion[] copiaProfunda = new Habitacion[tama�o];
        System.arraycopy(habitaciones, 0, copiaProfunda, 0, tama�o);
        return copiaProfunda;
    }

    public int getTamano() {
        return tama�o;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void insertar(Habitacion habitacion) {
        if (habitacion != null && buscarIndice(habitacion) == -1 && tama�o < capacidad) {
            habitaciones[tama�o] = habitacion;
            tama�o++;
        }
    }

    private int buscarIndice(Habitacion habitacion) {
        for (int i = 0; i < tama�o; i++) {
            if (habitaciones[i].equals(habitacion)) {
                return i;
            }
        }
        return -1;
    }

    private boolean tama�oSuperado(int indice) {
        return indice >= tama�o;
    }

    private boolean capacidadSuperada(int indice) {
        return indice >= capacidad;
    }

    public Habitacion buscar(Habitacion habitacion) {
        for (int i = 0; i < tama�o; i++) {
            if (habitaciones[i].equals(habitacion)) {
                return habitaciones[i];
            }
        }
        return null;
    }

    public void borrar(Habitacion habitacion) {
        int indice = buscarIndice(habitacion);
        if (indice != -1) {
            desplazarUnaPosicionHaciaIzquierda(indice);
            tama�o--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        if (!tama�oSuperado(indice)) {
            for (int i = indice; i < tama�o - 1; i++) {
                habitaciones[i] = habitaciones[i + 1];
            }
            habitaciones[tama�o - 1] = null; // �ltimo elemento a null
        }
    }
}