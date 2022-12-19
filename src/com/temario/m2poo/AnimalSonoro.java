package com.temario.m2poo;

@FunctionalInterface // Anotaci�n que limita los m�todos abstractos a uno para poder usarse con las capacidades de la programaci�n funcional (Expresiones lambda, clases anonimas, referencia a métodos...) 
public interface AnimalSonoro<T> extends PruebaInterfaz { // <T> -> Tipo de dato generico. Se especifica cuando lo implementamos en la clase. Se puede usar cualquier letra pero convenci�n se usa la T.
   
    int NUMERO = 10; // public static final (de forma implicita) - Solo podemos usar constantes
    
    void emitirSonido(); // public abstract (de forma implicita)
    
    //public abstract void emitirSonido2(); // Si descomentamos da error de compilaci�n al tener puesta la anotaci�n @FunctionalInterface
    
    private int metodoPrivado(){ // Podemos declarar m�todos privados para uso interno
        int numeroModificado = NUMERO+1;
        return numeroModificado;
    }
    default void metodoDefault(T t, int num){ // Los m�todos default son m�todos convecionales de las interfaces
        int result = num + metodoPrivado();
        System.out.println("El animal "+t.toString()+" emite "+ result+" sonidos.");
    } 
    static void sonidoApareamiento(){ // Tambi�n podemos usar m�todos est�ticos que se accedera a traves de 
        System.out.println("Grara grñgrñ");
    }
}
