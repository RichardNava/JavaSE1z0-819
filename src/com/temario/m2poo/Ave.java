package com.temario.m2poo;

import java.io.Serializable;
import java.util.List;

public class Ave extends Animal implements AnimalSonoro<Ave>, Serializable {
    private int numPatas;

    public Ave(int numPatas,String nombre, float peso, long edad, String color) {
        super(nombre, peso, edad, color);
        this.numPatas = numPatas;
    }

    public Ave() {

    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    @Override
    public String toString() {
        return super.toString() + "numPatas=" + numPatas + '}';
    }

    @Override
    public void mover() {
        System.out.println("Las aves vuelan");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Pio, pio");
    }

    @Override
    public void move() {
        System.out.println("El ave vuela");
    }

 
    
 
}
