package com.temario.m5io;

public class Employee implements java.io.Serializable {

    private static final long serialVersionUID = 1L; 
    
    public String name;
    public String address;
    public transient Integer SSN; // Los atributos marcados como transient no pasan por el proceso de serialización
    public int number;
    public Boolean isABoss;
    
    public void mailCheck(){
        System.out.println("Mailing a chech to "+name+" "+address);
    }
    

}
