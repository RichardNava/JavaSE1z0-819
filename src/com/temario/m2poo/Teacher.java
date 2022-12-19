package com.temario.m2poo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Teacher extends Person implements Adult {

    private double salary;
    private Course[] courses;

    public Teacher(double salary, Course[] courses, String name, String secondName, LocalDate birthDate, double height, double weight) {
        super(name, secondName, birthDate, height, weight);
        this.salary = salary;
        this.courses = courses;
    }

    public Teacher() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalary= " + salary + "\nCourses= " + courses;
    }

    @Override
    public void sendMessage() {
        System.out.println("Los profesores no se examinan");
    }

//    @Override
//    public double calculateIncome(double salary, double irpf) {
//        this.salary = salary;
//        return irpf * 100 / this.salary;
//    }

    @Override
    public double calculateIncome(BigDecimal irpf, BigDecimal taxes) {
        return 0.0;
    }

}
