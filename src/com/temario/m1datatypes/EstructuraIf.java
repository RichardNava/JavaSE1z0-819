package com.temario.m1datatypes;

import java.util.Scanner;

public class EstructuraIf {

    public void definirPar(Scanner sc) {
        System.out.println("Introduzca un n�mero entero: ");
        int num = sc.nextInt();
        if (num % 2 != 0) {
            System.out.println("El n�mero " + num + " es un n�mero impar.");
        } else {
            System.out.println("El n�mero " + num + " es un n�mero par.");
        }
    }

    public void mayorMenor(Scanner sc) {
        System.out.println("Introduzca n�mero 1: ");
        double num1 = sc.nextDouble();
        System.out.println("Introduzca n�mero 2: ");
        double num2 = sc.nextDouble();
        if (num1 > num2) {
            System.out.println("El n�mero " + num1 + " es mayor que " + num2);
        } else if (num1 < num2) {
            System.out.println("El n�mero " + num2 + " es mayor que " + num1);
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
                System.out.println("Es n�mero");
            }
        } else {
            System.out.println("No ha introducido ninguna palabra");
        }
    }

}
