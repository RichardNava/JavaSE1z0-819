/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.temario.m2poo;

/**
 *
 * @author richa
 */
public interface AnimalFunctions {
    int SPEED = 10; // Los atributos de una interfaz de forma implicita son public static final
    
    void move();
    
    default int correr(double peso){
        return (int) (SPEED/isHigherThan2(peso));
    }
    
    private static double isHigherThan2(double peso){
        return (peso<=2)? peso : peso*0.1;
    }
    
    static void speedValue(double peso){
        System.out.println(SPEED/isHigherThan2(peso));
    }
}
