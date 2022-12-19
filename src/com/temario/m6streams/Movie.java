package com.temario.m6streams;

public class Movie {
    private String title;
    private String director;
    private Genre genre;
    private PEGI pegi;
    private int year;
    private double rating;
    private boolean awards;
    private boolean watched;

    public Movie() {
    }

    public Movie(String title, String director, Genre genre, PEGI pegi, int year, double rating, boolean awards, boolean watched) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.pegi = pegi;
        this.year = year;
        this.rating = rating;
        this.awards = awards;
        this.watched = watched;
    }

    public PEGI getPegi() {
        return pegi;
    }

    public void setPegi(PEGI pegi) {
        this.pegi = pegi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAwards() {
        return awards;
    }

    public void setAwards(boolean awards) {
        this.awards = awards;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    @Override
    public String toString() {
        return title.toUpperCase() 
                + "\n\tDirector= " + director 
                + "\n\tGenre= " + genre 
                + "\n\tYear= "  + year 
                + "\n\tRating= " + rating 
                + "\n\tAwards= " + awards 
                + "\n\tWatched= " + watched;
    }
    
    
    
}
