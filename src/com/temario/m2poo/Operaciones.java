package com.temario.m2poo;

//@FunctionalInterface
public interface Operaciones extends Inter1, Inter2{
    
    public final int GRADOS = 90; // de forma implicita public static final 
    
    void girar(); // public abstract <tipo de devolución> <nombre/identificador><(parametros)><;>
    
//    void calcularSuperficie();
      
    default void girar(int grados){
        grados = comprobarGrados(grados);
        System.out.println("La figura se gira "+grados+" grados.");
    }
    static void mostrarGrados(){
        comprobarGrados(GRADOS);
        System.out.println("Los grados de un angulo recto son "+GRADOS);
    }
    private static int comprobarGrados(int grados){
        if(grados>=0 && grados<=360){
            return grados;
        }
        return 0;
    }
}
