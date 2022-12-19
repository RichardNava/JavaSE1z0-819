package com.temario.m1datatypes;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class EstructurasControl {
    
    // Método para invertir texto
    public String reverseText(BufferedReader br) throws IOException {
        System.out.println("Introduzca un texto:");
        String text = br.readLine();
        String inverseText = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            inverseText += String.valueOf(text.charAt(i));
//            inverseText = inverseText.concat(""+text.charAt(i)); // Similar
        }
        return inverseText;
    }

    public String reverseTextSB(BufferedReader br) throws IOException {
        System.out.println("Introduzca un texto:");
        return new StringBuilder(br.readLine()).reverse().toString();
    }

    public String convertCase(BufferedReader br, boolean mode) throws IOException {
        System.out.println("Introduzca un texto:");
        String text = br.readLine();
        String text2 = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
//            if((c>=65 && c<=90) || (c>=97 && c<=122)) {
//            MAYUSCULAS -> 65 - 90
//            MINUSCULAS -> 97 - 122
            if (Character.isLetter(c)) {
                if (mode) {
                    text2 += (Character.isLowerCase(c)) ? (char) (c - 32) : c;
                } else {
                    text2 += (Character.isUpperCase(c)) ? (char) (c + 32) : c;
                }
            } else {
                text += c;
            }
        }
        return text2;
    }

    public String convertCase(BufferedReader br, int mode) throws IOException {
        if (mode == 0) {
            return br.readLine().toUpperCase();
        } else if (mode == 1) {
            return br.readLine().toLowerCase();
        }
        return null;
    }

    public void notasIf(Scanner sc) {
        String notaCadena = "";
        System.out.println("Introduzca su nota");
        //int notaNumerica = Integer.parseInt(sc.nextLine());
        double notaNumerica;

        notaNumerica = sc.nextDouble();

        if (notaNumerica >= 0 && notaNumerica <= 10) {
            if (notaNumerica <= 2) {
                notaCadena = "Deficiente";
            } else if (notaNumerica < 5) {
                notaCadena = "Insuficiente";
            } else if (notaNumerica < 6) {
                notaCadena = "Suficiente";
            } else if (notaNumerica < 7) {
                notaCadena = "Bien";
            } else if (notaNumerica < 9) {
                notaCadena = "Notable";
            } else if (notaNumerica <= 10) {
                notaCadena = "Sobresaliente";
            }
        } else {
            notaCadena = "La nota no es valida";
        }
        // Versión con el operador ternario
        // notaCadena = notaNumerica < 5 ? "suspenso" : "aprobado";
        System.out.println("Nota: " + notaCadena);
    }

    public void switchSemana(Scanner sc) {
        System.out.println("Introduzca un número del 1 al 7: ");
        int diaSemana;
        diaSemana = sc.nextInt();

        switch (diaSemana) {
            case 6:
                System.out.println("Sábado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            case 2: // 2 == diaSemana
                System.out.println("Martes");
                break;
            case 1: // 1 == diaSemana
                System.out.println("Lunes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            case 5:
                System.out.println("Viernes");
                break;
            default:
                System.out.println("No es un dÃ­a la semana ");
                break;
        }
    }

}
