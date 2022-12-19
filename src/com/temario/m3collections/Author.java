/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m3collections;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author richa
 */
public class Author implements Comparable<Author> { // T = Author

    private String name, surName;
    private LocalDate dateOfBirth;

    public Author(String name, String surName, LocalDate dateOfBirth) {
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.surName);
        hash = 89 * hash + Objects.hashCode(this.dateOfBirth);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surName, other.surName)) {
            return false;
        }
        return Objects.equals(this.dateOfBirth, other.dateOfBirth);
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + ", surName=" + surName + ", dateOfBirth=" + dateOfBirth + '}';
    }

    @Override
    public int compareTo(Author o) {
//        int limit = this.name.length();
//        if(this.name.equals(o.name))
//            return 0;
//        if(this.name.length()!=o.name.length())
//            limit = Math.min(this.name.length(), o.name.length());
//        for(int i=0; i<limit;i++){
//            if(this.name.charAt(i)-o.name.charAt(i)!=0){
//                return this.name.charAt(i)-o.name.charAt(i);
//            }
//        }
        if(this.name.compareTo(o.name)!=0){
            return o.name.compareTo(this.name);
        }
        else if(o.surName.compareTo(this.surName) !=0){
            return o.surName.compareTo(this.surName);
        }
        else{
            return this.getDateOfBirth().getYear()-o.getDateOfBirth().getYear();
        }

    }

}
