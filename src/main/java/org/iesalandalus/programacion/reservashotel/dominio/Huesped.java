package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;

    private static final String ER_TELEFONO = "^(\\+\\d{1,3})?\\d{9,15}$";
    private static final String ER_CORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String FORMATO_FECHA = "dd-MM-yyyy";


    private String formateaNombre(String nombre) {
        String[] palabras = nombre.split(" ");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            resultado.append(palabra.substring(0, 1).toUpperCase()).append(palabra.substring(1).toLowerCase()).append(" ");
        }
        return resultado.toString().trim();
    }

    private void comprobarLetraDni(String dni) {
        Pattern patron = Pattern.compile("^(\\d{8})([A-Za-z])$");
        Matcher matcher = patron.matcher(dni);

        if (matcher.matches()) {
            String letrasValidas = "TRWAGMYFPDXBNJZSQVHLCKE";
            int numero = Integer.parseInt(matcher.group(1));
            int indice = numero % 23;
            char letraCalculada = letrasValidas.charAt(indice);

            if (letraCalculada != matcher.group(2).toUpperCase().charAt(0)) {
                throw new IllegalArgumentException("Letra del DNI incorrecta");
            }
        } else {
            throw new IllegalArgumentException("Formato de DNI no válido");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.matches("^[A-Z][a-z]+( [A-Z][a-z]+)*$")) {
            throw new IllegalArgumentException("Formato de nombre no válido");
        }
        this.nombre = formateaNombre(nombre);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("Formato de teléfono no válido");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (!correo.matches(ER_CORREO)) {
            throw new IllegalArgumentException("Formato de correo no válido");
        }
        this.correo = correo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        comprobarLetraDni(dni);
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Huesped(String nombre, String telefono, String correo, String dni, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setTelefono(telefono);
        setCorreo(correo);
        setDni(dni);
        setFechaNacimiento(fechaNacimiento);
    }

    public Huesped(Huesped huesped) {
        this.nombre=huesped.nombre;
        this.telefono=huesped.telefono;
        this.correo=huesped.correo;
        this.dni=huesped.dni;
        this.fechaNacimiento=huesped.fechaNacimiento;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Huesped huesped = (Huesped) obj;
        return dni.equals(huesped.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return String.format("nombre=%s, DNI=%s, correo=%s, teléfono=%s, fecha nacimiento=%s",
                nombre, dni, correo, telefono, fechaNacimiento.format(DateTimeFormatter.ofPattern(FORMATO_FECHA)));
    }
}