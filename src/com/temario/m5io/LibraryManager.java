package com.temario.m5io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LibraryManager {

    private final Set<Book> books = new HashSet<>();
    private final Set<Author> authors = new HashSet<>();
    private final String path;

    public LibraryManager(String path) {
        this.path = path;
        File filePath = new File(path);
        try {
            if (filePath.exists()) {
                createFiles();
            } else {
                filePath.mkdirs();
                createFiles();
            }
        } catch (IOException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE, "Se ha producido un error", ex);
        }
        updateData();
    }

    public void menu() {
        String option;
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr)) {
            do {
                option = input(br, """
                                   Seleccione una opci\u00f3n:
                                   \tA) Introducir un escritor
                                   \tB) Introducir un libro
                                   \tC) Mostrar los escritores
                                   \tD) Mostrar los libros
                                   \tE) Salir""");
                if (option.trim().toUpperCase().startsWith("A")) {
                    writer(path + "autores.txt", createAuthorText(br));
                } else if (option.trim().toUpperCase().startsWith("B")) {
                    writer(path + "libros.txt", createBookText(br));
                } else if (option.trim().toUpperCase().startsWith("C")) {
                    updateData();
                    authors.forEach(a -> System.out.println(a));
                } else if (option.trim().toUpperCase().startsWith("D")) {
                    updateData();
                    books.forEach(b -> System.out.println(b));
                } else if (option.trim().toUpperCase().startsWith("E")) {
                    System.out.println("Gracias por usar LibraryManager.");
                } else {
                    System.out.println("No se que quieres. Intentalo de nuevo.");
                }
            } while (!option.trim().toUpperCase().startsWith("E"));
        } catch (IOException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String input(BufferedReader br, String msg) throws IOException {
        System.out.println(msg);
        return br.readLine();
    }

    public void writer(String path, String data) {
        try (FileWriter out = new FileWriter(path, true);
                BufferedWriter bw = new BufferedWriter(out)) {
            bw.write(data);
            bw.newLine();
        } catch (IOException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE,
                    "La acciÃ³n no se ha podido llevar a cabo", ex);
        }
    }

    public void reader(String path, Collection<Book> books) {
        try (FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
//                System.out.println(linea);
                String[] bookData = linea.split(",");
                books.add(new Book(bookData[0],
                        findAuthorByDNI(bookData[1]),
                        Integer.parseInt(bookData[2]),
                        parseGenre(Integer.parseInt(bookData[3]))));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE, "No existe un archivo con ese nombre", ex);
        } catch (IOException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE, "Ha surgido un problema ", ex.getClass().getSimpleName());
        } catch (NumberFormatException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE,
                    "Debe introducir un número válido ",
                    ex.getClass().getSimpleName());
        }

    }

    public void reader(String path, Set<Author> authors) {
        try (FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
//                System.out.println(linea);
                String[] authorData = linea.split(",");
                authors.add(Author.ofAutor(authorData[0], authorData[1], authorData[2]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE, "No existe un archivo con ese nombre", ex);
        } catch (IOException ex) {
            Logger.getLogger(LibraryManager.class.getName()).log(Level.SEVERE, "Ha surgido un problema ", ex.getClass().getSimpleName());
        }

    }

    public Author findAuthorByDNI(String DNI) {
        for (Author author : authors) {
            if (author.getDNI().equals(DNI)) {
                return author;
            }
        }
        return Author.ofAutor("Anónimo", "Desconocido", "NO DNI");
    }

    public String createAuthorText(BufferedReader br) throws IOException {
        String author = "";
        author = author.concat(input(br, "Introduce el nombre del autor:") + ",");
        author = author.concat(input(br, "Introduce el primer apellido del autor:") + ",");
        author = author.concat(input(br, "Introduce el DNI del autor:"));
        return author;
    }

    public String createBookText(BufferedReader br) throws IOException {
        StringBuilder book = new StringBuilder("");
        return book.append(input(br, "Introduce el tí­tulo del libro: ").concat(","))
                .append(input(br, "Introduce el DNI del autor del libro: ").concat(","))
                .append(input(br, "Introduce el número ISBN: ").concat(","))
                .append(input(br, """
                                  Elige el g\u00e9nero del libro: 
                                  1- DRAMA
                                  2- ACCION
                                  3- ROMANTICA
                                  4- CIENCIA FICCION
                                  5- TERROR
                                  6- OTRO""")).toString();
    }

    public void updateData() {
        reader(path + "autores.txt", authors);
        reader(path + "libros.txt", books);
    }

    public void createFiles() throws IOException {
        File filePath = new File(path + "autores.txt");
        if (!filePath.exists()) {
            filePath.createNewFile();
        }
        filePath = new File(path + "libros.txt");
        if (!filePath.exists()) {
            filePath.createNewFile();
        }
    }

    public Genre parseGenre(int ordinal) {
        return (ordinal > 0 && ordinal < 6) ? Genre.values()[ordinal] : Genre.values()[0];
    }
}
