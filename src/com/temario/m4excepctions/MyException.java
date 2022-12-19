package com.temario.m4excepctions;

public class MyException extends Exception { // podemos personalizar nuestra excepciones heredando de Throwable/Exception o alguno de sus herederos

    public static final String MESSAGE = "Mensaje de error personalizado";
    
    // Cuando personalizamos una excepción utilizamos los constructores de la superclases de una manera personalizada
    public MyException() { 
        super(MESSAGE);
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
