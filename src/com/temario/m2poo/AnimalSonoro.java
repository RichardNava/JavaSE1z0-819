package com.temario.m2poo;

@FunctionalInterface // Anotación que limita los métodos abstractos a uno para poder usarse con las capacidades de la programación funcional (Expresiones lambda, clases anonimas, referencia a mÃ©todos...) 
public interface AnimalSonoro<T> extends PruebaInterfaz { // <T> -> Tipo de dato generico. Se especifica cuando lo implementamos en la clase. Se puede usar cualquier letra pero convención se usa la T.
   
    int NUMERO = 10; // public static final (de forma implicita) - Solo podemos usar constantes
    
    void emitirSonido(); // public abstract (de forma implicita)
    
    //public abstract void emitirSonido2(); // Si descomentamos da error de compilación al tener puesta la anotación @FunctionalInterface
    
    private int metodoPrivado(){ // Podemos declarar métodos privados para uso interno
        int numeroModificado = NUMERO+1;
        return numeroModificado;
    }
    default void metodoDefault(T t, int num){ // Los métodos default son métodos convecionales de las interfaces
        int result = num + metodoPrivado();
        System.out.println("El animal "+t.toString()+" emite "+ result+" sonidos.");
    } 
    static void sonidoApareamiento(){ // También podemos usar métodos estáticos que se accedera a traves de 
        System.out.println("Grara grÃ±grÃ±");
    }
}
