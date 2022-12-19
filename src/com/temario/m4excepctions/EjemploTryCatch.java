package com.temario.m4excepctions;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.InputMismatchException;

public class EjemploTryCatch {

    private static final Logger LOG = Logger.getLogger(EjemploTryCatch.class.getName()); // El log nos permite imprimir mensajes con opciones adionales que aportan metadatos para ser más descriptivos con nuestros "errore"

    public int division(int op1, int op2) {
        int result;
        try { // Especificamos el bloque try para aquellas instrucciones susceptibles de provocar expeciones
            result = op1 / op2;
        } catch (ArithmeticException e) { // El los bloques catch, atrapamos las excepciones si coinciden con lo que tenemos declarado entre ()
            result = 0;
            LOG.log(Level.SEVERE, "No se puede dividir entre 0"); // En el log podemos especificar nivel del "error" (Level) / Mensaje / uso del objeto exception y sus distintos métodos 
//            throw e; // podemos lanzar el objeto que almacena la instancia de la excepcion
        }
        return result;
    }

    public int division(int op1, Integer op2) throws MyException {
        int result = op1 / throwMyException(op2);
        return result;
    }

    public int division(Scanner sc) {
        int result;
        try { // El bloque try debe ir acompañado de un/unos bloques catch y/o un bloque finally
            System.out.println("Introduzca el divisor: ");
            int op1 = sc.nextInt(); // Esta linea puede provocar InputMismatchException si el usuario no introduce por teclado un número entero valido
            System.out.println("Introduzca el dividendo : ");
            int op2 = Integer.parseInt(sc.next()); // Esta linea puede provocar NumberFormatException si el usuario no introduce un número por teclado
            result = op1 / op2; // Esta linea puede provocar ArithmeticException si el usuario introduce 0 como valor al dividendo
            System.out.println("El resultado de la división es "+result);
        } //        catch(Exception e){ // Error de compilación: Si utilizamos varios catchs que tienen jerarquia entre si, el orden adecuado es de subclases a superclases
        //            LOG.log(Level.WARNING,"Error desconocido");
        //        }
        catch (NumberFormatException | InputMismatchException e) { // Podemos usar un multicatch declarando varias posibles excepciones separadas con | y con el mismo identificador. No podemos usar clases (excepciones) que tengan jerarquia entre si
            LOG.log(Level.INFO, "Debe introducir un número entero.");
        } catch (ArithmeticException e) {
            LOG.log(Level.SEVERE, "No se puede dividir entre 0.");
        } catch (Exception e) { // Aqui si
            LOG.log(Level.WARNING, "Error desconocido");
        } finally { // El bloque finally se ejecuta siempre, salvo si en una linea precedente usamos System.exit()
            result = 0;
            // EJEMPLO DEL USO ORIGINAL DEL finally{}
//            if (sc != null) { // El principal motivo de la existencia del bloque finally es cerrar recursos que implementan AutoCloseable/Closeable y habilitan buffers en memoria para almacenar información. Ha día de hoy esta practica se hace con try with resources que nos permite usar menos código 
//                try {
//                    sc.close();
//                }
//                catch(IllegalStateException e){
//                    System.out.println("El objeto ha sido cerrado previamente");
//                }
//            }
        }
        return result;
    }

    public void metodoPropagador() throws IOException { //las excepciones unchecked (RuntimeException) no es necesaria propagarlas (throws) para lanzarlas (throw), pero esta permitido hacerlo
        System.out.println("Soy un método que propaga IOException");
    }

    public int throwMyException(int n) throws MyException {
        if (n >= 0) {
            System.out.println("El número es correcto");
        } else {
            throw new MyException("El número no es valido"); // Para lanzar una excepción tenemos que propagarla a no ser que sea unchecked (RuntimeException)
        }
        return n;
    }


}




