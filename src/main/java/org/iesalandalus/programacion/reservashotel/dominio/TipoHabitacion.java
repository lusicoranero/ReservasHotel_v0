package org.iesalandalus.programacion.reservashotel.dominio;

public enum TipoHabitacion {
    SUITE("Suite",4),
    SIMPLE("Simple",1),
    DOBLE("Doble",2),
    TRIPLE("Triple",3);


    private String descripcion;
    private int numeroMaximoPersonas;

    private TipoHabitacion( String descripcion, int numeroMaximoPersonas){
        this.descripcion= descripcion;
        this.numeroMaximoPersonas= numeroMaximoPersonas;
    }
    public int getNumeroMaximoPersonas() {
        return numeroMaximoPersonas;
    }

    @Override
    public String toString() {
        return "Tipo de habitación " + descripcion + '\'' +
                ", Número máximo de personas=" + numeroMaximoPersonas;
    }
}