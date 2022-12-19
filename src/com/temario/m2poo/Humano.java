package com.temario.m2poo;

public class Humano  {
    //CLASS FIELDS 
    private String nombre; 
    private String apellido;
    protected String NIF;
    public float peso;
    float altura; // package-private
    
    // CONSTRUCTORES
    public Humano(String nombre, String apellido, String NIF, float peso, float altura) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.NIF = NIF;
        this.peso = peso;
        this.altura = altura;
    }

    public Humano() {
    }
    //Accessors Methods (Getters&Setters)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
       this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return nombre +":"+ 
               "\n\tApellido=" + apellido + 
               "\n\tNIF=" + NIF + 
               "\n\tPeso=" + peso + 
               "\n\tAltura=" + altura;
    }

    public void luchar(){
        System.out.println("Hago daño");
    }

    
    
}