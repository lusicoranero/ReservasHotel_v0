package org.iesalandalus.programacion.reservashotel.dominio;

public enum Regimen {
    SOLO_ALOJAMIENTO("Solo Alojamiento", 0),
    ALOJAMIENTO_DESAYUNO("Alojamiento y desayuno",15),
    MEDIA_PENSION("Media pensi�n", 30),
    PENSION_COMPLETA("Pensi�n completa",50);

    private String descripcion;
    private double incrementoPrecio;

    private Regimen( String descripcion, int incrementoPrecio){
        this.descripcion= descripcion;
        this.incrementoPrecio= incrementoPrecio;
    }

    @Override
    public String toString() {
        return "Regimen "+ descripcion + '\'' +
                ", incremento de precio=" + incrementoPrecio;
    }
}


