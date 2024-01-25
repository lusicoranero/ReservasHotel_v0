package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Habitacion;

public class Habitaciones {
    private Habitacion[] habitaciones;
    private int capacidad;
    private int tamaño;

    public Habitaciones(int capacidad) {
        this.capacidad = capacidad;
        this.tamaño = 0;
        this.habitaciones = new Habitacion[capacidad];
    }

    public Habitacion[] get() {
        Habitacion[] copiaProfunda = new Habitacion[tamaño];
        System.arraycopy(habitaciones, 0, copiaProfunda, 0, tamaño);
        return copiaProfunda;
    }

    public int getTamano() {
        return tamaño;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void insertar(Habitacion habitacion) {
        if (habitacion != null && buscarIndice(habitacion) == -1 && tamaño < capacidad) {
            habitaciones[tamaño] = habitacion;
            tamaño++;
        }
    }

    private int buscarIndice(Habitacion habitacion) {
        for (int i = 0; i < tamaño; i++) {
            if (habitaciones[i].equals(habitacion)) {
                return i;
            }
        }
        return -1;
    }

    private boolean tamañoSuperado(int indice) {
        return indice >= tamaño;
    }

    private boolean capacidadSuperada(int indice) {
        return indice >= capacidad;
    }

    public Habitacion buscar(Habitacion habitacion) {
        for (int i = 0; i < tamaño; i++) {
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
            tamaño--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        if (!tamañoSuperado(indice)) {
            for (int i = indice; i < tamaño - 1; i++) {
                habitaciones[i] = habitaciones[i + 1];
            }
            habitaciones[tamaño - 1] = null; // Último elemento a null
        }
    }
}