package com.temario.m2poo;

import com.temario.m3collections.Product;

public class Movie extends Product {
    private String director;
    private String[] starrings;
    private double IMDBrating;

    public Movie(String director, String[] starrings, double IMDBrating, long id, String name, String genre, int year) {
        super(name, genre, year);
        this.director = director;
        this.starrings = starrings;
        this.IMDBrating = IMDBrating;
    }

    public Movie() {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getStarrings() {
        return starrings;
    }

    public void setStarrings(String[] starrings) {
        this.starrings = starrings;
    }

    public double getIMDBrating() {
        return IMDBrating;
    }

    public void setIMDBrating(double IMDBrating) {
        this.IMDBrating = IMDBrating;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nDirector= " + director 
                + "\nProtagonistas= " + starrings 
                + "\nValoración IMDB= " + IMDBrating;
    }
    
    
}
