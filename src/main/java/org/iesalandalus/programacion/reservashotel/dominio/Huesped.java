package org.iesalandalus.programacion.reservashotel.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Huesped {

    private final String ER_TELEFONO= "(?:\\+34 )?(9\\d{2}) \\d{6}|(9\\d) \\d{7}";
    private final String ER_CORREO= "\\w+[\\.\\w]*@\\w+[\\.\\w]*\\.\\w{2,5}\\b\\s?";
    private final String ER_DNI= "([0-9]{8})([A-Za-z])";
    public final String FORMATO_FECHA= "dd/MM/yyyy";
    private String nombre;
    private String telefono;
    private String correo;
    private String dni;
    private LocalDate fechaNacimiento;


    private String formateaNombre(String nombre) {
        /* Quitamos los espacios en blanco, dividimos el nombre en las palabras que hayan y damos formato
        al nombre, poniento la primera letra de cada palabra en mayusculas */

        nombre = nombre.trim();
        String[] palabras = nombre.split("\\s+");

        StringBuilder nombreFormateado = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                palabra = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
                nombreFormateado.append(palabra).append(" ");
            }

        }
        return nombreFormateado.toString().trim();
    }

    private Boolean comprobarLetraDni (String dni){

        //Comprobamos que la letra es válida, para ello necesitamos el resto de dividir el número entre 23

        Pattern patron;
        Matcher comparador;
        Boolean comprobacion;
        patron = Pattern.compile(ER_DNI);
        comparador = patron.matcher(dni);
        int restoVeintitres;
        String letrasDni = "TRWAGMYFPDXBNJZSQVHLCKE";
        restoVeintitres= Integer.parseInt(comparador.group(1))%23;
        String letraDni=comparador.group(2);

        //Si la posicion del resto del número entre 23 en el String letrasDni coincide con nuestra letra, es valida

        if (letraDni.charAt(0)==letrasDni.charAt(restoVeintitres))
            comprobacion=true;
        else
            comprobacion=false;

        return comprobacion;

    }

    public void setNombre(String nombre) {
        this.nombre = formateaNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        Pattern patron;
        Matcher comparador;

        patron = Pattern.compile(ER_TELEFONO);
        comparador = patron.matcher(telefono);
        if (!comparador.matches())
            this.telefono = telefono;
        else
            throw new IllegalArgumentException("El número de teléfono no tiene un formato válido");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {


        Pattern patron;
        Matcher comparador;

        patron = Pattern.compile(ER_CORREO);
        comparador = patron.matcher(correo);

        if (comparador.find())
            this.correo = correo;
        else
            throw new IllegalArgumentException("El correo electrónico no tiene un formato válido");
    }


    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {

        //comprobamos si el formato del dni es correcto comparando el patron descrito en ER_DNI con el dni

        Pattern patron;
        Matcher comparador;
        Boolean comprobacion;


        patron = Pattern.compile(ER_DNI);
        comparador = patron.matcher(dni);
        comprobacion=comprobarLetraDni(dni);

        //Si el formato es correcto y la letra tambien, asignamos el valor, sino lanzamos excepciones

        if(comparador.matches()&& comprobacion)
            this.dni = dni;
        else if (comparador.matches())
            throw new IllegalArgumentException("El dni no tiene un formato válido");
        else
            throw new IllegalArgumentException("La letra del DNI no es correcta");
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        String fechaFormateada = fechaNacimiento.format(formatter);

        if (fechaFormateada.equals(fechaNacimiento.toString()))
            this.fechaNacimiento = fechaNacimiento;
        else
            throw new IllegalArgumentException("El formato de la fecha no es válido");
    }

    private String getIniciales(){

        StringBuilder iniciales = new StringBuilder();

        // Dividir el nombre en palabras
        String[] palabras = nombre.split("\\s+");

        // Obtener la primera letra de cada palabra y agregarla a las iniciales
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                iniciales.append(palabra.charAt(0));
            }
        }
        return iniciales.toString().toUpperCase();
    }

    public Huesped(String nombre, String telefono, String correo, String dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Huesped(Huesped huesped) {
        this.nombre = huesped.nombre;
        this.telefono = huesped.telefono;
        this.correo = huesped.correo;
        this.dni = huesped.dni;
        this.fechaNacimiento = huesped.fechaNacimiento;
    }


}


