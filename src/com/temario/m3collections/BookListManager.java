package com.temario.m3collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class BookListManager {

    private final List<Book> books = new ArrayList<>();
    private final BufferedReader br;
    public BookListManager(BufferedReader br) {
        this.br = br;
        books.add(new Book("Araceli Lauret", 124, "Bubok", "El corazón de Vicky", "Aventuras", 2009));
        books.add(new Book("James Joyce", 350, "MBG", "Ulises", "Expiremental", 1985));
        books.add(new Book("Julio Cortazar", 346, "Planeta","Rayuela", "Drama", 1963));
    }

    //CRUD - Create Read Update Delete
    public List<Book> maiMenu(Scanner sc) throws IOException {
        int control = 1;
        do {
            System.out.println("""
Elija una opción:
    1- Crear un libro
    2- Buscar un libro
    3- Ver todos los libros
    4- Modificar un libro
    5- Eliminar un libro
    0- Salir 
                           """);
            control = sc.nextInt();
            switch (control) {
                case 1:
                    createBook();
                    System.out.println("¿Quiere continuar añadiendo libros? (Y/N)");
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    readAllList();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    deleteBook(sc);
                    break;
                case 0:
                    System.out.println("Gracias por usar la aplicación. Hasta la próxima.");
                    break;
                default:
                    System.out.println("No reconozco esa instrucción. Intentelo de nuevo.");
            }
            if(control != 0) pause();
        } while (control != 0);

        return books;
    }

    public void showBook() throws IOException {
        System.out.println("Introduzca el nombre de un libro:");
        String name = br.readLine();
        for (Book book : books) {
            System.out.println(book.getName());
            if (book.getName().equalsIgnoreCase(name)) {
                System.out.println(book);
                break;
            }
        }
    }

    public void readAllList() throws IOException {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i) + "\n" + "-".repeat(40));
            if(i!=books.size()-1) pause();
        }
    }

    public void updateBook() throws IOException {
        ListIterator<Book> it = books.listIterator();
        System.out.println("Indique el id del registro que quiere modificar: ");
        int id = Integer.parseInt(br.readLine());
        while (it.hasNext()) {
            Book next = it.next();
            if (next.getId() == id) {
                it.remove();
                it.add(createBook());
            }
        }
    }

    public void deleteBook(Scanner sc) {
        Iterator<Book> it = books.iterator();
        System.out.println("Indique el id del registro que quiere eliminar: ");
        int id = sc.nextInt();
        while (it.hasNext()) {
            Book next = it.next();
            if (next.getId() == id) {
                it.remove();
            }
        }
    }

    public Book createBook() throws IOException {

            System.out.println("Introduzca el titulo del libro: ");
            String title = br.readLine();
            System.out.println("Introduzca el género del libro: ");
            String genre = br.readLine();
            System.out.println("Introduzca el autor del libro: ");
            String autor = br.readLine();
            System.out.println("Introduzca el año del libro: ");
            int year = Integer.parseInt(br.readLine());
            System.out.println("Introduzca la editorial del libro: ");
            String editorial = br.readLine();
            System.out.println("Introduzca las páginas del libro: ");
            int pages = Integer.parseInt(br.readLine());
            Book book = new Book(autor, pages, editorial, title, genre, year);
            books.add(book);
            return book;

    }
    public void pause() throws IOException{
        System.out.println("Pulse cualquier tecla para continuar...");
        br.readLine();
    }
}
