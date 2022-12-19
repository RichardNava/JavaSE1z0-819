package com.temario.m2poo;

public abstract class Animal implements AnimalFunctions{
    private String nombre;
    private float peso; // Atributos o campos de clase
    private long edad;
    private String color;

    public Animal(String nombre,float peso, long edad, String color) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        this.color = color;
    }

    public Animal() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Getter&Setters (Accessors Methods)
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
 
    public long getEdad() {
        return edad;
    }

    public void setEdad(long edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" + "peso=" + peso + ", edad=" + edad + ", color=" + color + '}';
    } 
    
    public abstract void mover();

    
    
}
