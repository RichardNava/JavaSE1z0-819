//
package com.temario.m1datatypes;

import java.util.Scanner;

public class Bucles {
    
    public void usandoWhile(Scanner sc){
        boolean cond=true;
        int n = 0;
        System.out.println("Bucle While: Escribe \"Out\" para abandonar el bucle o espera 10 vueltas" );
        while (cond && n<10) {            
            n++;
            System.out.println("n vale: "+n);
            System.out.println("¿Quieres seguir? (Introduzca Out para salir o cualquier cosa para continuar)");
            if(sc.next().equalsIgnoreCase("Out")){
                cond=false;
            }
        }        
        
//        while (n<10) {            
//            n++;
//            System.out.println("n vale: "+n);
//        }
        
    }
    
    public void usandoDoWhile(int n){
        System.out.println("Bucle do-while: ");
        do {            
            n++;
            System.out.println("\tValor de n "+n);
        } while (n<10);
    }
    
    public void usandoFor(){
        System.out.println("Bucle for:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("\tVuelta nº: "+i);
        }
//        for (;true;) { // Bucle infinito
//          
//        } 
    }
    
}
