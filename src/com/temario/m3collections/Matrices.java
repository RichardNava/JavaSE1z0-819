package com.temario.m3collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Matrices {

    private String[] nombres;
    private String[][] nombresBi;

    public void maiMenu(BufferedReader br) throws IOException, InterruptedException {
        int control = 1;
        do {
            System.out.println("""
Elija una opción:
    1- Crear una matriz de nombres
    2- Crear una matriz bidimensional de nombres
    3- Mostrar matriz de nombres
    4- Mostrar matriz bidimensional de nombres
    0- Salir 
                           """);
            control = Integer.parseInt(br.readLine());
            switch (control) {
                case 1:
                    nombres = crearMatriz(br);
                    break;
                case 2:
                    crearBiMatriz(br);
                    break;
                case 3:
                    if (nombres != null) {
                        mostrarMatriz(nombres);
                    } else {
                        System.out.println("Primero debes crear la matriz de nombres");
                    }
                    break;
                case 4:
                    if (nombresBi != null) {
                        mostrarBiMatriz(nombresBi);
                    } else {
                        System.out.println("Primero debes crear la matriz Bidimensional");
                    }
                    break;
                case 0:
                    System.out.println("Gracias por usar la aplicación. Hasta la próxima.");
                    break;
                default:
                    System.out.println("No reconozco esa instrucción. Intentelo de nuevo.");
            }

        } while (control != 0);
    }

    public String[] crearMatriz(BufferedReader br) throws IOException {
        System.out.println("Indique el número de nombres que desea introducir: ");
        int cant = Integer.parseInt(br.readLine());
        String[] names = new String[cant];
        for (int i = 0; i < names.length; i++) {
            System.out.println("Introduce el " + (i + 1) + "º nombre: ");
            names[i] = br.readLine();
        }
        return names;
    }

    public String[][] crearBiMatriz(BufferedReader br) throws IOException {
        System.out.println("Indique el número de conjuntos de nombres que quieres crear: ");
        int cant = Integer.parseInt(br.readLine());
        nombresBi = new String[cant][];
        for (int i = 0; i < nombresBi.length; i++) {
            System.out.println("Matriz nº " + (i + 1) + ":");
            nombresBi[i] = crearMatriz(br);
        }
        return nombresBi;
    }

    public void mostrarMatriz(String[] datos) {
        for (String dato : datos) {
            System.out.println("\tEl nombre es: " + dato);
        }

    }

    public void mostrarBiMatriz(String[][] datos) throws InterruptedException {
        int contador = 1;
        System.out.println("----------------------------");
        for (String[] dato : datos) {
            System.out.println("Conjunto de datos " + contador);
            mostrarMatriz(dato);
            System.out.println("----------------------------");
            contador++;
        }        
        Thread.sleep(1000);
    }
}
