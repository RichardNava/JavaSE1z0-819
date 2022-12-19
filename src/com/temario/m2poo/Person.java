package com.temario.m2poo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person{

    // Campos de clase
    private String name; // package-private
    private String secondName;
    private LocalDate birthDate;
    private double height;
    private double weight;

    //Declaramos constructores
    public Person(String name, String secondName, LocalDate birthDate, double height, double weight) {
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    public Person() {

    }

    // Métodos de acceso
    // [Modificador de acceso][Tipo de devolución][nombre del metodo][(Parametros/Argumentos)][{ return }]
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Name= " + name + "\nSecondName= " + secondName + "\nBirthDate= " + birthDate + "\nHeight= " + height + "\nWeight= " + weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final Person other = (Person) obj;
        return Objects.equals(this.name, other.name);
    }

    public final void sayHello() {
        System.out.println("Hola " + name);
    }

    public abstract void sendMessage();
}
