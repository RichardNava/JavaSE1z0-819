package com.temario.m2poo;

class Estados{
    String nombre;
    int valor;
    boolean activado;

    public Estados(String nombre, int valor, boolean activado) {
        this.nombre = nombre;
        this.valor = valor;
        this.activado = activado;
    }
    
}
public abstract class Figura2D implements Operaciones, Inter1, Inter2 {
    private int x;
    private int y;
    private String[] estados = {"ON","OFF","UNKNOW"};
    private Estados estado;
    private int valorEstado;
    private Estados[] estados2 = {new Estados("ON",1,true),
                                  new Estados("OFF",2,false),
                                  new Estados("UNKNOW",3,false)};
    

    
    public Figura2D(int x, int y) {
        this.x = x;
        this.y = y;
//        estado = estados2[pos];
//        valorEstado = verificarEstado();
    }
    
    public abstract double calcularArea();
    
    public void mostrarArea(){
        System.out.println("El "+this.getClass().getSimpleName()+" tiene un area de."+calcularArea());
    }
    
//    public int verificarEstado(){
//        switch (estado) {
//            case "ON":
//                return 1;
//            case "OFF":
//                return 2;
//            case "UNKNOW":
//                return 3;
//            default:
//                return 4;
//        }
//    }
}
