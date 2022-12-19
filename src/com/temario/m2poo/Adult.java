package com.temario.m2poo;

import java.math.BigDecimal;


public interface Adult {
    public static final double TAX = 4.6; // De forma implícita es public static final

    public abstract double calculateIncome(BigDecimal irpf,BigDecimal taxes);
    
    private static double calculateTax(){
        // Bloque de instrucciones 
        return TAX*0.10;
    }
    public static void showTax(){
        System.out.println(calculateTax());
    }
    default double calculateIncome(BigDecimal irpf){ // Las reglas la sobrecarga de métodos es tener distinto tipo y/o número de argumentos          
        return calculateIncome(irpf,irpf.multiply(BigDecimal.valueOf(TAX)));
   
    }
}
