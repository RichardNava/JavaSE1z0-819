package com.temario.m7concurrency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings({"CallToThreadStartDuringObjectConstruction","IndexOfReplaceableByContains"})
public class BuscarPalabra implements Runnable {

    private volatile String palabra;
    private final Thread hilo;
    private final AtomicInteger cant = new AtomicInteger(0); // versión thread safe de Integer. No funciona el autoboxing
    private final AtomicBoolean modo = new AtomicBoolean(false); // versión del boolean Thread safe

    public BuscarPalabra(String palabra) {
        this.palabra = palabra;
        hilo = new Thread(this);
        hilo.start();
        while (hilo.isAlive()) { // Este m�todo nos devuelve true mientras el hilo este operativo
            //En este bucle no hacemos nada, solo esperar            
        }
        System.out.println("La palabra " + palabra + " se encuentra contenida en "
                + cant + " archivos.");
    }

    public BuscarPalabra(String palabra, boolean modo) {
        this.palabra = palabra;
        this.modo.set(modo);
        hilo = new Thread(this);
        hilo.start();
        while (hilo.isAlive()) {
        }
        System.out.println("La palabra " + palabra + " se encuentra contenida en "
                + cant + " archivos.");
    }

    @Override
    public void run() {
        File ar = new File("C:\\Prueba\\Textos\\");
        String[] directorio = ar.list();
        for (String arch : directorio) {
            if (!modo.get()) {
                if (tiene(arch)) {
                    cant.getAndIncrement(); // Similar a cant++;
                }
            } else {
                if (tieneBlock(arch)) {
                    cant.incrementAndGet(); // Similar a ++cant;
                }
            }

        }
    }

    // El modificador de m�todo "synchronized" bloque la entrada a otros hilos cuando un hilo esta ejecutando
    // el bloque de instrucciones. Afecta a todo el bloque de instrucciones del método
    private synchronized boolean tiene(String archivo) {
//        boolean existe = false;
        try (FileReader fr = new FileReader("C:\\Prueba\\Textos\\" + archivo);
                BufferedReader br = new BufferedReader(fr)) {
            String linea = br.readLine();
            while (linea != null) {
                if (linea.contains(palabra)) {
                    return true;
                }
                linea = br.readLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(BuscarPalabra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    private boolean tieneBlock(String archivo) {
        // Un bloque synchronized atrapa un recurso mientras un hilo lo esta utilizando y bloque la entrada
        // a otros hilos. Solo queda bloqueado el bloque, no afecta al resto de instrucciones del método
        synchronized (this) {
            try (FileReader fr = new FileReader("C:\\Prueba\\Textos\\" + archivo);
                    BufferedReader br = new BufferedReader(fr)) {
                String linea = br.readLine();
                while (linea != null) {
                    if (linea.indexOf(palabra) != -1) {
                        return true;
                    }
                    linea = br.readLine();
                }

            } catch (IOException ex) {
                Logger.getLogger(BuscarPalabra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Instrucciones fuera del bloque synchronized
        return false;
    }
}
