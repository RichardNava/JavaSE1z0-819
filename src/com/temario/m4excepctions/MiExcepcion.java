package com.temario.m4excepctions;

public class MiExcepcion extends Exception {
    private String message;

    public MiExcepcion() {
    }
    
    
    public MiExcepcion(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
       
}