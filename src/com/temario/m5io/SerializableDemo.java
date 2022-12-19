package com.temario.m5io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("CallToPrintStackTrace")
public class SerializableDemo {

    public void demoEmployee() {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        try (FileOutputStream fileOut = new FileOutputStream("C:\\Prueba\\Serializacion\\employee.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(e);
        } catch (IOException ex) {
            Logger.getLogger(SerializableDemo.class.getName()).log(Level.SEVERE, "Error", ex);
        }
    }

    public void readEmployee() {
        Employee e = null;
        try (FileInputStream fileIn = new FileInputStream("C:\\Prueba\\Serializacion\\employee.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);) { // Debe existir la ruta para poder crear el archivo          

            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (InvalidClassException c) {
            System.out.println("El archivo serializado con coincide con la versión actual de la clase");
            c.printStackTrace();
            return;
        } catch (IOException i) {
            System.out.println("");
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
        System.out.println("Es un jefe: " + e.isABoss);
    }
}
