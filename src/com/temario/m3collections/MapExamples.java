/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m3collections;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author richa
 */
public class MapExamples {

    // ESTRUCTURA MAP
    // clave-> Set<T> valor -> Collection<T>
    // Map<Clave, Valor> -> Map<Set<T>,Collection<T>>
    // Map<String, Integer> -> Map<Set<String>,Collection<Integer>>
    public Map<Author, List<Book2>> writers = new HashMap<>();

    private final Author aut1 = new Author("Stephen", "King", LocalDate.of(1965, Month.MARCH, 12));
    private final Author aut2 = new Author("James", "Joyce", LocalDate.of(1951, Month.OCTOBER, 8));
    private final Author aut3 = new Author("Julio", "Cortazar", LocalDate.of(1945, Month.JUNE, 25));

    private final Book2 book1 = new Book2(aut3, "Rayuela", Genre.DRAMA, 12345);
    private final Book2 book2 = new Book2(aut3, "Cosas de pensar", Genre.DRAMA, 671243);
    private final Book2 book3 = new Book2(aut2, "Ulises", Genre.HISTORICA, 245312);
    private final Book2 book4 = new Book2(aut2, "Rayuela", Genre.SCIFI, 891235);
    private final Book2 book5 = new Book2(aut1, "Carrie", Genre.TERROR, 112345);
    private final Book2 book6 = new Book2(aut1, "IT", Genre.TERROR, 192345);

    public MapExamples() {

        List<Book2> booksJulioCortazar = new ArrayList<>(List.of(book1, book2));
        List<Book2> booksJamesJoyce = new ArrayList<>(List.of(book3, book4));
        List<Book2> booksStephenKing = new ArrayList<>(List.of(book5, book6));
        
        
        writers.put(aut2, booksJamesJoyce);
        writers.put(aut1, booksStephenKing);
        writers.put(aut3, booksJulioCortazar);
    }

    public Map<Author, List<Book2>> showAllInfo() {
        Set<Author> authors = writers.keySet();
        for (Author author : authors) {
            System.out.println(author);
            List<Book2> books = writers.get(author);
            for (Book2 book : books) {
                System.out.println("\t" + book);
            }
        }
        //writers.forEach((k,v)-> System.out.println("Escritor: "+k+"\n\t"+v)); // Alternativa usando forEach()
        return writers;
    }

    public void showBooksInfo() {
        Collection<List<Book2>> books = writers.values();
        for (List<Book2> value : books) {
            for (Book2 book : value) {
                System.out.println(book);
            }
        }
    }

    public List<Book2> enterRegister(Author aut, List<Book2> books) {
        if (writers.containsKey(aut)) {
            System.out.println("El autor ya se encuentra en la base de datos.");
        } else {
            return writers.put(aut, books);
        }
        return books;
    }

    public List<Book2> enterRegister(Author aut, Book2... books) {
        return writers.putIfAbsent(aut, Arrays.asList(books));
    }
    
    public List<Book2> updateRegisters(Author aut, Book2... books){
        return writers.replace(aut1,createList());
    }

    public List<Book2> createList(Book2... books){
         return Arrays.asList(books);       
    }
    
    public List<Book2> remove(Author aut){
        return writers.remove(aut);
    }
    
    public Map<Author,List<Book2>> sortMap(){
        return new TreeMap<>(writers);
    }
}
