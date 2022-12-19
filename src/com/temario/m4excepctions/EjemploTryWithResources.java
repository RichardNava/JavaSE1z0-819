package com.temario.m4excepctions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploTryWithResources {

    public void pruebaTWC() {

        try (Recurso r = new Recurso()) {
            System.out.println(r.getClass().getName()+": abierto");
        } catch (Exception ex) {
            Logger.getLogger(EjemploTryWithResources.class.getName()).log(Level.SEVERE, "Se ha provocado una excepción", ex);
        }
    } // r.close();
}

class Recurso implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println(this.getClass().getName()+": cerrado");
    }

}
