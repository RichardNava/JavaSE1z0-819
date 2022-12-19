package com.temario.m4excepctions;

import java.io.FileNotFoundException;

public class TestExcepcion {
    
    public void lanzarExcepcion() throws MiExcepcion{
        System.out.println("Estoy en mi excepción.");
        throw new MiExcepcion();
    }
    public void lanzarExcepcion2() throws FileNotFoundException{
        System.out.println("Lanzo FileNotFoundException.");
        throw new FileNotFoundException();
    }
    
}
