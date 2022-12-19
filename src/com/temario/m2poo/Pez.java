package com.temario.m2poo;

public class Pez extends Animal{  
    private String especie;

    public Pez() {
    }

    public Pez(String especie, String nombre, float peso, long edad, String color) {
        super(nombre, peso, edad, color);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return super.toString() + "especie=" + especie + '}';
    }

    @Override
    public void mover() {
        System.out.println("Los peces nadan.");
    }

    @Override
    public void move() {
        System.out.println("El pez nada.");
    }
    
     
    
    
    
}
