package org.iesalandalus.programacion.reservashotel.negocio;

import org.iesalandalus.programacion.reservashotel.dominio.Huesped;

import java.time.LocalDate;

public class Huespedes {
    private int capacidad;
    private int tamaño;
    private Huesped[] listaHuespedes;

    public Huespedes(int capacidad) {
        this.capacidad = capacidad;
        this.tamaño = 0;
        this.listaHuespedes = new Huesped[capacidad];
    }

    private Huesped[] copiaProfundaHuespedes() {
        // Aqui hacemos la copia profunda recorriendo el array

        Huesped[] copiaHuespedes = new Huesped[tamaño];
        for (int i = 0; i < tamaño; i++) {
            copiaHuespedes[i] = new Huesped(
                    listaHuespedes[i].getNombre(),
                    listaHuespedes[i].getTelefono(),
                    listaHuespedes[i].getCorreo(),
                    listaHuespedes[i].getDni(),
                    listaHuespedes[i].getFechaNacimiento()
            );
        }
        return copiaHuespedes;
    }

    public int getTamaño() {

        return tamaño;
    }

    public int getCapacidad() {

        return capacidad;
    }

    public void insertar(Huesped huesped) {
        if (tamaño < capacidad) {
            listaHuespedes[tamaño] = huesped;
            tamaño++;
        } else {
            throw new IllegalStateException("No hay capacidad para más huéspedes");
        }
    }

    private int buscarIndice(Huesped huesped) {
        for (int i = 0; i < tamaño; i++) {
            if (listaHuespedes[i].equals(huesped)) {
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

    public Huesped buscar(Huesped huesped) {
        for (int i = 0; i < tamaño; i++) {
            if (listaHuespedes[i].equals(huesped)) {
                return listaHuespedes[i];
            }
        }
        return null;
    }

    public void borrar(Huesped huesped) {
        int indice = buscarIndice(huesped);
        if (indice != -1) {
            desplazarUnaPosicionHaciaIzquierda(indice);
            tamaño--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < tamaño - 1; i++) {
            listaHuespedes[i] = listaHuespedes[i + 1];
        }
        listaHuespedes[tamaño - 1] = null;
    }
}