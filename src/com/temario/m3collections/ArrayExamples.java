package com.temario.m3collections;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("MismatchedReadAndWriteOfArray")
public class ArrayExamples {
    // FORMAS DE DECLARAR MATRICES (matrices)

    int[] numeros1 = new int[10];
    int numeros2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] numeros3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static {

        // DECLARACI脫N DE ARRAYS UTILIZANDO VARIABLE DE TIPO INFERIDO (var)
        var numeros4 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var numeros5 = new int[5];
        // ERRORES DE COMPILACI覰       
        // var numeros4 ={1,2,3,4,5,6,7,8,9,10}; // en un array se debe especificar el tipo con la variable de tipo inferido
        // var[] numeros4 = new int[]{1,2,3,4,5,6,7,8,9,10}; // no se puede usar [] en la referencia (parte izquierda de la declaraci贸n) 
        // var numer4 = null; // la variable de tipo inferido no puede inicializarse a null
    }

    // Ejercicio 1: Crear una m閠odo que dado un n鷐ero cree una matriz de n鷐eros desde 1 
    // hasta dicho n鷐ero. Imprimir los n鷐eros impares y devolver la matriz.
    // PROHIBICION: No se pueden usar estructuras IF
    public int[] matNumbers(Scanner sc) {
        int[] numbers = new int[sc.nextInt()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        return numbers;
    }

    public void breakContinue() {
        int result = 0;
        BucleA:
        for (int i = 0; i < 2; i++) { //Labels
            System.out.println("Estoy en A");
            //result++;
            BucleB:
            for (int j = 0; j < 2; j++) {
                System.out.println("\tEstoy en B");
                //if (result>50) break;
                BucleC:
                for (int k = 0; k < 2; k++) {
                    System.out.println("\t\tEstoy en C");
                    if (i % 2 == 0) {
                        continue BucleA;
                    }
                    if (k > j) {
                        break;
                    }
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public void showArray3D(int[][][] args) {
        for (int[][] arg : args) {
            for (int[] is : arg) {
                for (int i : is) {
                    System.out.println(i);
                }
            }
        }
    }

    public void showArray3D(int[][][] args, String name) {
        for (int[][] arg : args) {
            for (int[] is : arg) {
                for (int i : is) {
                    System.out.println(name + " " + i);
                }
            }
        }
    }

    public void showArray3D(String[][][] args) {
        for (String[][] arg : args) {
            for (String[] is : arg) {
                for (String i : is) {
                    System.out.println(i);
                }
            }
        }
    }

    public void showArray3D(Perro[][][] args) {
        for (Perro[][] arg : args) {
            for (Perro[] is : arg) {
                for (Perro i : is) {
                    System.out.println(i);
                }
            }
        }
    }

    public char[] stringToArray(String text) {
        char[] forceLetters = text.toCharArray(); // Con este m閠odo podemos convertir un texto a una matriz de tipo char
        System.out.println(Arrays.toString(forceLetters));
        return forceLetters;
    }

    public int arraysMethods(String[] arr1, String... arr2) { // El uso de ... nos permite pasar una matriz como argumento de una manera m谩s c贸moda
        Arrays.sort(arr1); // El m茅todo est谩tico sort nos permite ordenar los elementos
        Arrays.sort(arr2); // de un array bajo su criterio natural o el que este establecido en la implementaci贸n del compareTo() (interfaz Comparable) 
        int miss = Arrays.mismatch(arr1, arr2); // Nos devuelve la primera posici贸n en la que encontramos un elemento distinto, nos devuelve -1 si no hay diferencias.
        if (arr1 == arr2 || miss == -1) {
            System.out.println("Las arrays son identicas");
            return 0;
        }
        int length = Arrays.compare(arr1, arr2);
        if (length == 0) {
            System.out.println("Las dos matrices tienen el mismo n煤mero de elementos");
        } else if (length < 0) {
            System.out.println("Las segunda matriz es mayor");

        } else {
            System.out.println("Las primera matriz es mayor");
        }
//        int posMiss = (Arrays.compare(arr1, arr2) == 0)
//                ? // El compare() (interfaz Comparator) nos permite comparar arrays entre s铆, respecto a su length (tama帽o) -> arr1.length - arr2.length 
//                Arrays.binarySearch(arr1, arr2[miss]) // binarySearch() nos devuelve la posici贸n en la que se encuentra el segundo argumento, si no existe nos devuelve la (hipot茅tica posici贸n * -1) -1                 
//                : 
//                (Arrays.binarySearch(arr1, arr2[miss]) * -1) - 1;
        int posMiss = (Arrays.binarySearch(arr1, arr2[miss]) * -1) - 1;
        System.out.println("El elemento distinto se encontrar铆a en la posici贸n "
                + posMiss);
        return posMiss;
    }

    public void ejemplos(Scanner sc) {
        String[] nombres = new String[4]; // 0 hasta lenght-1
        nombres[0] = "Ricardo";
        nombres[1] = "Adolfo";
        nombres[2] = "Aroa";
        nombres[3] = "Daniel";

        System.out.println(nombres[0]);
        //0   1    2    3
        double[] decimales = new double[]{2.5, 6.8, 9.10, 14.3};
        System.out.println(decimales[3]);

        char[] letras = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(letras));

        Perro perro1 = new Perro("Bobby", "Pitbull", 20.5, "negro");
        Perro perro2 = new Perro("Mandela", "Chihuaua", 2.3, "marron");
        Perro perro3 = new Perro("Smurpy", "Bull Dog", 8.7, "gris");
        Perro perro4 = new Perro("Odin", "American Stanford", 34.3, "blanco");
        perro1.ladrar();

        System.out.println(perro1); //perro1.toString();
//        Perro[][] perros = new Perro[2][2];
//        perros[0][0] = perro1;
//        perros[0][1] = perro2;
//        perros[1][0] = perro3;
//        perros[1][1] = perro4;
        //     0                  1          
        Perro[][] perros = {{perro1, perro2}, {perro3, perro4}};
        //  0       1         0      1      
//        System.out.println(perros[0].ladrar());
//        System.out.println(perro1.ladrar());

        int[][][] numeros = new int[][][]{
            {{1, 5, 7}, {2, 6, 8}},
            {{9, 4, 3, 88}},
            {{10, 20, 30}, {60, 80, 90}, {100, 200, 300}}
        };
        System.out.println(Arrays.toString(numeros[2][2]));

        String[][][] cube = new String[2][2][2];
        cube[0][0][0] = "Cuarto de inicio. Sin peligros";
        cube[0][0][1] = "Cuarto de fuego. Peligro";
        cube[0][1][0] = "Cuarto de cuchillos. Peligro";
        cube[0][1][1] = "Cuarto de almohadas. No peligro";
        cube[1][0][0] = "Cuarto de hielo. Depende";
        cube[1][0][1] = "Cuarto de colchonetas. Depende";
        cube[1][1][0] = "Cuarto de rayos laser. Muerte asegurada";
        cube[1][1][1] = "Salida";

        Perro[][][] perros3D = new Perro[2][][];
        perros3D[0] = perros;
        perros3D[1] = perros;

        System.out.println(cube[1][1][1]);

        System.out.println("Introduzca un texto para convetirlo en una matriz de char");
        stringToArray(sc.nextLine());

        arraysMethods(nombres, "Paco", "Lucia", "Ambrosio", "Mario"); // Cambiar nombres para obtener distintos resultados

    }

}

class Perro {

    String nombre;
    String raza;
    double peso;
    String color;

    public Perro(String nombre, String raza, double peso, String color) {
        this.nombre = nombre;
        this.raza = raza;
        this.peso = peso;
        this.color = color;
    }

    public String ladrar() {
        return nombre + "GUAU GUAU";
    }

    @Override
    public String toString() {
        return "Perro{nombre=" + nombre + ", raza=" + raza + ", peso=" + peso + ", color=" + color + '}';
    }

}
