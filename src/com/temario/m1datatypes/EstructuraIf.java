package com.temario.m1datatypes;

import java.util.Scanner;

public class EstructuraIf {

    public void definirPar(Scanner sc) {
        System.out.println("Introduzca un número entero: ");
        int num = sc.nextInt();
        if (num % 2 != 0) {
            System.out.println("El número " + num + " es un número impar.");
        } else {
            System.out.println("El número " + num + " es un número par.");
        }
    }

    public void mayorMenor(Scanner sc) {
        System.out.println("Introduzca número 1: ");
        double num1 = sc.nextDouble();
        System.out.println("Introduzca número 2: ");
        double num2 = sc.nextDouble();
        if (num1 > num2) {
            System.out.println("El número " + num1 + " es mayor que " + num2);
        } else if (num1 < num2) {
            System.out.println("El número " + num2 + " es mayor que " + num1);
        } else {
            System.out.println(num1 + " y " + num2 + " son iguales.");
        }

    }

    public void compCarInicial(Scanner sc) {
        System.out.println("Introduzca una palabra: ");
        String palabra = sc.next();
        if (!palabra.isBlank()) {
            if (Character.isLetter(palabra.charAt(0))) {
                System.out.println("Es texto");
            } else if (Character.isDigit(palabra.charAt(0))) {
                System.out.println("Es número");
            }
        } else {
            System.out.println("No ha introducido ninguna palabra");
        }
    }

}
