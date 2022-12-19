package com.temario.m4excepctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.SQLException;

@SuppressWarnings("LocalVariableHidesMemberVariable")
public class CifradoCesar {

    private int code;

    public enum Mode {
        ENCODE, DECODE;
    }

    public String cesarEncrypt(BufferedReader br, Mode m) throws IOException, InputMismatchException, SQLException { // Propagamos SQLException para probarlo en la llamada
        String text = "", newText = "";
        int code = 0;
        do {
            System.out.println("Introduzca un texto: ");
            text = br.readLine();
        } while (text.isEmpty());
        do {
            System.out.println("Introduzca el código de desplazamiento: ");
            code = Integer.parseInt(br.readLine());
            this.code = code;

        } while (code == 0);
        switch (m) {
            case DECODE:
                code = code * -1;
                break;
        }
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))) {
                newText += (char) (text.charAt(i) + (code % 26));
            } else {
                newText += text.charAt(i);
            }
        }
        return newText;
    }

    public String cesarEncrypt(String txt, Mode m) throws IOException, InputMismatchException, SQLException { // Propagamos SQLException para probarlo en la llamada
        String newText = "";

        int code = 0;

        do {
            code = (int) (Math.random() * 10 + 1);

        } while (code == 0);
        switch (m) {
            case DECODE:
                code = this.code * -1;
                break;
        }
        for (int i = 0; i < txt.length(); i++) {
            if (Character.isLetter(txt.charAt(i))) {
                newText += (char) (txt.charAt(i) + (code % 26));
            } else {
                newText += txt.charAt(i);
            }
        }
        return newText;
    }

}
