package com.temario.m2poo;


public class PJ extends Humano{ 
    enum Armas{
        ESPADA,HACHA,ARCO,LANZA;
    }
    private int fuerza;
    private int salud;
    private int resistencia;
    private Clase clase;
    private Armas arma;
//    public PJ(int fuerza, int salud, int resistencia) {
//        this.fuerza = fuerza;
//        this.salud = salud;
//        this.resistencia = resistencia;
//    }
//
//    public PJ() {
//    }

    public PJ(int fuerza, int salud, int resistencia, Clase clase, String nombre, String apellido, String NIF, float peso, float altura) {
        super(nombre, apellido, NIF, peso, altura);
        this.fuerza = fuerza;
        this.salud = salud;
        this.resistencia = resistencia;
        this.clase = clase;
    }
        
    public PJ(int fuerza, int salud, int resistencia, String nombre, String apellido, String NIF, float peso, float altura) {
        super(nombre, apellido, NIF, peso, altura);
        this.fuerza = fuerza;
        this.salud = salud;
        this.resistencia = resistencia;
    }

    public PJ() {
        super();
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return super.toString() + 
               "\nFuerza=" + fuerza + 
               "\nSalud=" + salud + 
               "\nResistencia=" + resistencia;
    }

}

