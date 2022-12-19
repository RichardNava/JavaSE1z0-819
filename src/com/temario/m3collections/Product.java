
package com.temario.m3collections;

public class Product {
    private static long id;
    private String name;
    private String genre;
    private int year;
    
    public Product(String name, String genre, int year) {
        id = ++id;
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Titulo: "+name
                +"\n\tId: "+id
                +"\n\tGénero: "+genre
                +"\n\tAño: "+year;
    }
    
    
}
