package com.temario.m5io;

import java.util.Objects;

public class Book {
    private String title;
    private Author autor;
    private int ISBN;
    private Genre genre;

    public Book() {
    }

    public Book(String title, Author autor, int ISBN, Genre genre) {
        this.title = title;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAutor() {
        return autor;
    }

    public void setAutor(Author autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return title.toUpperCase() + ":\n\tAutor: " + autor + "\n\tISBN: " + ISBN + "\n\tgenre: " + genre + '\n';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + this.ISBN;
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
        final Book other = (Book) obj;
        if (this.ISBN != other.ISBN) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        return this.genre == other.genre;
    }
    
}
