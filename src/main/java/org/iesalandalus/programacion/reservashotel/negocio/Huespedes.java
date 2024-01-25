package org.iesalandalus.programacion.reservashotel.negocio;

import java.time.LocalDate;

public class Huespedes {
    private int capacidad;
    private int tama�o;
    private Huesped[] listaHuespedes;

    public Huespedes(int capacidad) {
        this.capacidad = capacidad;
        this.tama�o = 0;
        this.listaHuespedes = new Huesped[capacidad];
    }

    public Huesped[] copiaProfundaHuespedes() {
        // Devuelve una copia profunda del array
        Huesped[] copiaHuespedes = new Huesped[tama�o];
        for (int i = 0; i < tama�o; i++) {
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

    public int getTama�o() {
        return tama�o;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void insertar(Huesped nuevoHuesped) {
        if (tama�o < capacidad) {
            listaHuespedes[tama�o] = nuevoHuesped;
            tama�o++;
        } else {
            throw new IllegalStateException("No hay capacidad para m�s hu�spedes");
        }
    }

    public int buscarIndice(Huesped huesped) {
        for (int i = 0; i < tama�o; i++) {
            if (listaHuespedes[i].equals(huesped)) {
                return i;
            }
        }
        return -1;
    }

    public boolean tama�oSuperado(int indice) {
        return indice >= tama�o;
    }

    public Huesped buscar(Huesped huesped) {
        for (int i = 0; i < tama�o; i++) {
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
            tama�o--;
        }
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < tama�o - 1; i++) {
            listaHuespedes[i] = listaHuespedes[i + 1];
        }
        listaHuespedes[tama�o - 1] = null;
    }
}