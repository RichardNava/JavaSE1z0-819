package com.temario.m1datatypes;



@SuppressWarnings("InitializerMayBeStatic")
public class EjemploStatic {

    public int num1;
    public static int num2;

    static { //Inicializador estático. Siempre es lo primero en ejecutarse
        System.out.println("Inicializador de instancia estático");
        System.out.println("\t"+saludar("Laura")); 
//        despedirse("Laura"); // Da error de compilación. Los elementos estáticos solo admiten elementos estáticos
        System.out.println("\t"+new EjemploStatic().despedirse("Laura")); // Podemos acceder a miembros no estáticos a traves de la instancia
    }

    { // Inicializador de instancia 1. Se ejecuta antes que el constructor
        String saludo = EjemploStatic.saludar("Paco"); // Los miembros estáticos son accesibles a tráves de la clase 
        System.out.println("Inicializador de instancia 1 \n\t"+saludo); 
    }
    
    public EjemploStatic() {
        num2++; // El valor de las campos de clase estáticos se comparten en todas las instancias
        System.out.println("Llamada al constructor nº "+num2);
    }
    
    { // Inicializador de instancia 2. Se ejecuta antes que el constructor y después del Inicializador de instancia 1
        System.out.println("Inicializador de instancia 2 \n\t"+despedirse("Paco"));
    }

    public static String saludar(String nombre) {
        return "Hola " + nombre;
    }

    public String despedirse(String nombre) {
        return "Adios " + nombre;
    }
}
