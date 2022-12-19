package com.temario.m5io;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("CallToPrintStackTrace")
public class IOExamples {

    // EJEMPLO de PrintStream
    public void printStreamExample(String dir, String text) {
        try (PrintStream out = new PrintStream(dir)) { // Si el archivo (en la ruta) que pasamos al constructor no existe, se crea.
            out.println(text); // Por defecto PrintStream trabaja en modo sobreescritura (el texto nuevo sustituye al existente) 
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(IOExamples.class.getName()).log(Level.WARNING, "El archivo no existe. " + ex.getClass().getSimpleName());
        }
    }

    // EJEMPLO de PrintStream + FileOutputStream -> esta sobrecarga del constructor de PrintStream me permite trabajar en modo append
    public void printStreamExample(String dir, String text, boolean mod) {
        // <TIPO DE DATO> <NOMBRE> <=> <INSTANCIA>
        try (FileOutputStream fos = new FileOutputStream(dir, mod); // Usando un objeto de tipo FileOutputStream podemos hacer que nuestro PrintStream se comporte en modo append
                PrintStream ps = new PrintStream(fos)) { // Si el archivo (en la ruta) que pasamos al constructor no existe, se crea.
            ps.println(text); // Por defecto PrintStream trabaja en modo sobreescritura (el texto nuevo sustituye al existente) 

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(IOExamples.class.getName()).log(Level.WARNING, "El archivo no existe. Excepcion: {0}", ex.getClass().getSimpleName());
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(IOExamples.class.getName()).log(Level.SEVERE, "Se ha producido un error", ex);
        }
    }

    // EJEMPLO DE FileWriter
    public void fileWriterExample(String dir, boolean mod, String... texts) {
        try (FileWriter fw = new FileWriter(dir, mod)) { // true - Modo append -> false - Modo sobreescritura
            for (String text : texts) {
                fw.write(text + "\n"); // Si trabajamos en modo append, el FileWriter nos añade el texto en la misma fila, si queremos crear una nueva fila tenemos que indicar el salto de carro "\n"
            }
        } catch (IOException ex) {
            Logger.getLogger(IOExamples.class.getName()).log(Level.SEVERE, "error");
        }
    }

    // EJEMPLO BufferedWriter
    public void bufferedWriterExample(String dir, String... texts) {
        try (FileWriter fw = new FileWriter(dir, true);
                BufferedWriter bw = new BufferedWriter(fw)) {
            for (int i = 0; i < texts.length; i++) {
                bw.write(texts[i]);
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(IOExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // RECURSOS ESCRITURA
    // EJEMPLO BufferedReader
    public String input() {
        String text = "";
        try (InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in)) {
            System.out.println("Introduzca un texto: ");
//            int a = Integer.parseInt(br.readLine());
//            System.out.println("Introduzca otro número: ");
//            int b = Integer.parseInt(br.readLine());
//            System.out.println("La suma de los números es = " + (a + b));
            text = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(IOExamples.class.getName()).log(Level.SEVERE, "Se ha producido un error inesparado", ex);
        } 
        
        return text;
    }
    

    
}
