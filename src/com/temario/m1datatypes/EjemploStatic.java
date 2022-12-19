package com.temario.m1datatypes;



@SuppressWarnings("InitializerMayBeStatic")
public class EjemploStatic {

    public int num1;
    public static int num2;

    static { //Inicializador est�tico. Siempre es lo primero en ejecutarse
        System.out.println("Inicializador de instancia est�tico");
        System.out.println("\t"+saludar("Laura")); 
//        despedirse("Laura"); // Da error de compilaci�n. Los elementos est�ticos solo admiten elementos est�ticos
        System.out.println("\t"+new EjemploStatic().despedirse("Laura")); // Podemos acceder a miembros no est�ticos a traves de la instancia
    }

    { // Inicializador de instancia 1. Se ejecuta antes que el constructor
        String saludo = EjemploStatic.saludar("Paco"); // Los miembros est�ticos son accesibles a tr�ves de la clase 
        System.out.println("Inicializador de instancia 1 \n\t"+saludo); 
    }
    
    public EjemploStatic() {
        num2++; // El valor de las campos de clase est�ticos se comparten en todas las instancias
        System.out.println("Llamada al constructor n� "+num2);
    }
    
    { // Inicializador de instancia 2. Se ejecuta antes que el constructor y despu�s del Inicializador de instancia 1
        System.out.println("Inicializador de instancia 2 \n\t"+despedirse("Paco"));
    }

    public static String saludar(String nombre) {
        return "Hola " + nombre;
    }

    public String despedirse(String nombre) {
        return "Adios " + nombre;
    }
}
