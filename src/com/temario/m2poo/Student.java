package com.temario.m2poo;

import java.time.LocalDate;
import java.util.List;

public class Student extends Person {

    private double assessment;
    private boolean isPass;
    private List<Subjects> subjects;
    // Constructores

    public Student(double assessment, boolean isPass, String name, String secondName, LocalDate birthDate, double height, double weight) {
        super(name, secondName, birthDate, height, weight);
        this.assessment = assessment;
        this.isPass = isPass;
    }

    public Student(double assessment, boolean isPass, List<Subjects> subjects, String name, String secondName, LocalDate birthDate, double height, double weight) {
        super(name, secondName, birthDate, height, weight);
        this.assessment = assessment;
        this.isPass = isPass;
        this.subjects = subjects;
    }
    
    public Student() {
        super(); // Esto llama al constructor sin argumentos de la superclase, esta de forma implicita
    }
    
    public List<Subjects> getSubjects() {
        return subjects;
    }

    //Getters & Setters
    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }

    public boolean isIsPass() {
        return isPass;
    }

    public void setIsPass(boolean isPass) {
        this.isPass = isPass;
    }
    //toString

    @Override
    public String toString() {
        return super.toString()+"\nAssessment= " + assessment + "\nisPass= " + isPass;
    }

    @Override
    public void sendMessage(){
        if (isPass) {
            System.out.println("El alumno "+super.getName()+" ha aprobado");
        }
        else{
            System.out.println("El alumno "+super.getName()+" ha suspendido");
        }
    }
  
}
