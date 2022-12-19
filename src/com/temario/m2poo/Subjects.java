package com.temario.m2poo;

public enum Subjects {
    MATEMATICAS(10,true),
    HISTORIA(8,true),
    FISICA(15,false),
    QUIMICA(12,false),
    LENGUAJE(6,true),
    GEOGRAFIA(11,false);
    
    private int credits;
    private boolean optionals;

    private Subjects(int credits, boolean optionals) {
        this.credits = credits;
        this.optionals = optionals;
    }

    public int getCredits() {
        return credits;
    }

    public boolean isOptionals() {
        return optionals;
    }
    
    
    
}
