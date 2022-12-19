package com.temario.m5io;

import java.util.Objects;

public class Author implements Comparable<Author> {

    private String nombre;
    private String apellido;
    private String DNI;

    private Author(String nombre, String apellido, final String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
    }

    private Author(String nombre, final String DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }

    public static Author ofAutor(String nombre, final String DNI) {
        return new Author(nombre, DNI);
    }

    public static Author ofAutor(String nombre, String apellido, final String DNI) {
        return new Author(nombre, apellido, DNI);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDNI() {
        return DNI;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - DNI: " + DNI;    
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Author autor) {
            return this.DNI.equals(autor.getDNI());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.DNI);
        return hash;
    }

    @Override
    public int compareTo(Author o) {
        if (!this.nombre.equals(o.nombre)) {
            int length = Math.min(this.nombre.length(), o.nombre.length());
            for (int i = 0; i < length; i++) {
                int compare = this.nombre.charAt(i) - o.nombre.charAt(i);
                if (compare != 0) {
                    return compare;
                }
            }
//             return Arrays.compare(this.nombre.toCharArray(), o.nombre.toCharArray());
        }

        return Integer.parseInt(o.DNI.substring(0, o.DNI.length() - 1)) - Integer.parseInt(this.DNI.substring(0, this.DNI.length() - 1));
//        return o.nombre.length()-this.nombre.length();
    }

}