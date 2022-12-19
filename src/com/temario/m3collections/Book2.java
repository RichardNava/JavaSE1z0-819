/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m3collections;

import java.util.Objects;

/**
 *
 * @author richa
 */
public class Book2 {

    private Author author;
    private String title;
    private Genre genre;
    private final int ISB;

    public Book2(Author author, String title, Genre genre, int ISB) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.ISB = ISB;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getISB() {
        return ISB;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.author);
        hash = 59 * hash + this.ISB;
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
        final Book2 other = (Book2) obj;
        if (this.ISB != other.ISB) {
            return false;
        }
        return Objects.equals(this.author, other.author);
    }

    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", title=" + title + ", genre=" + genre + ", ISB=" + ISB + '}';
    }

}
