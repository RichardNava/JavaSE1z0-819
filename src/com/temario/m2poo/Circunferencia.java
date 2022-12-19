package com.temario.m2poo;

public class Circunferencia extends Figura2D{
    
    private double radio;

    public Circunferencia(double radio, int x, int y) {
        super(x, y);
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double calcularArea(){
        return Math.PI*Math.pow(radio, 2);
    }

    @Override
    public void girar() {
        System.out.println("Giramos la figura.");
    }

    @Override
    public void m1() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int m1(char c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
