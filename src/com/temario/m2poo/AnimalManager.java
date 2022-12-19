/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m2poo;

import java.util.List;

/**
 *
 * @author richa
 */
public class AnimalManager {

    
    // Ejemplos de sobrecargas de métodos con polimorfia
    public static List<Animal> metodo(List<Animal> list, float newHeight, String newName) {
        for (Animal animal : list) {
            if (animal instanceof Ave) { //== != > < >= <= instaceof
                animal.setPeso(newHeight);
            } else if (animal instanceof Pez) {
                animal.setNombre(newName);
            }
        }

        return list;
    }

    public static List<Animal> metodo(List<Animal> list, String newName) {

        for (Animal animal : list) {

            if (animal instanceof Pez) {
                animal.setNombre(newName);
            }
        }

        return list;
    }

    public static List<Animal> metodo(List<Animal> list, float newHeight) {
        for (Animal animal : list) {
            if (animal instanceof Ave) {
                animal.setPeso(newHeight);
            }
        }
        return list;
    }
}
