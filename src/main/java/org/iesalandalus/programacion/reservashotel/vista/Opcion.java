package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    SALIR("Salir"),
    INSERTAR_HUESPED("Insertar huesped"),
    BUSCAR_HUESPED("Buscar huesped"),
    BORRAR_HUESPED("Borrar huesped"),
    MOSTRAR_HUESPEDES("Mostrar huéspedes"),
    INSERTAR_HABITACION("Insertar habitación"),
    BUSCAR_HABITACION("Buscar habitación"),
    BORRAR_HABITACION("Borrar habitación"),
    MOSTRAR_HABITACIONES("Mostrar habitaciones"),
    INSERTAR_RESERVA("Insertar reserva"),
    ANULAR_RESERVA("Anular reserva"),
    MOSTRAR_RESERVAS("Mostrar reservas"),
    CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad");
    public final String mensajeAMostrar;

    private Opcion(String mensajeAMostrar){
        this.mensajeAMostrar=mensajeAMostrar;
    }

    @Override
    public String toString() {
        return "Opcion{" +
                "mensajeAMostrar='" + mensajeAMostrar + '\'' +
                '}';
    }
}
