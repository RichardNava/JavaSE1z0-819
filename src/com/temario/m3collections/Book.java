package com.temario.m3collections;

public class Book extends Product {
    private String author;
    private int pages;
    private String editorial;

    public Book(String author, int pages, String editorial, String name, String genre, int year) {
        super(name, genre, year);
        this.author = author;
        this.pages = pages;
        this.editorial = editorial;
    }
    public Book() {
        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPags() {
        return pages;
    }

    public void setPags(int pages) {
        this.pages = pages;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n\tAuthor= " + author 
                + "\n\tNº Páginas=" + pages 
                + "\n\tEditorial=" + editorial;
    }
    
    
}
