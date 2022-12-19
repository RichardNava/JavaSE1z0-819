/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m5io;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author richa
 */
public class NIOExamples {

    public void demoPath() throws IOException {
        Path relative = Paths.get("..\\file2.txt");
//        Path path1 = Paths.get("nuevoTexto.txt");
        System.out.println("Relative path: " + relative);
        Path absolute = relative.toAbsolutePath();
        System.out.println("Absolute path: " + absolute);

        Path path = Paths.get("D:\\Programaci�n\\Apuntes\\Resumen\\texto.txt");
        FileSystem fs = path.getFileSystem();
        System.out.println(fs.provider());
        System.out.println("isAbsolute() -> " + path.isAbsolute());
        System.out.println("getFileName() -> " + path.getFileName());
        System.out.println("toAbsolutePath() -> " + relative.toAbsolutePath());
        System.out.println("getRoot() -> " + path.getRoot());
        System.out.println("getParent() -> " + path.getParent());
        System.out.println("getNameCount() -> " + path.getNameCount());
        System.out.println("getName() -> " + path.getName(1));
        System.out.println("subpath() -> " + path.subpath(0, path.getNameCount() - 1));
        System.out.println(path.toString());
        System.out.println("getNameCount() -> " + path.getNameCount());
        Path realPath = path.toRealPath();
        System.out.println(realPath.toString());
        String originalPath = "D:\\Programación\\Apuntes\\Resumen\\texto.txt";
        Path path1 = Paths.get(originalPath);
        Path path2 = path1.normalize();
        System.out.println("normalize() -> " + path2);
        System.out.println("relativize() -> " + path1.relativize(absolute));
    }

    public void filesRead(Path filePath, Charset charset) {
        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            for (String line : lines) {
                System.out.println(line);
            }

        } catch (IOException ex) {
            Logger.getLogger(NIOExamples.class.getName()).log(Level.SEVERE, "Archivo no encontrado", ex);
            System.out.println(ex);
        }
    }

    public void filesWrite(Path filePath, Charset charset, String message) {
        List<String> lists = List.of("Esto es", "una prueba de", "el método write(iterable)");
        try { // Ir descomentando los métodos para probarlos
            Files.write(filePath, message.getBytes(), StandardOpenOption.APPEND);
//            Files.write(filePath, lists, charset, StandardOpenOption.APPEND);
//            Files.writeString(filePath, message, charset, StandardOpenOption.APPEND);

        } catch (IOException ex) {
            Logger.getLogger(NIOExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void renameToFile(Path origenPath, Path destinoPath) {
        File file = new File(origenPath.toString());
        boolean move = file.renameTo(destinoPath.toFile());
        if (move) {
            System.out.println("Archivo movido con éxito");
        } else {
            System.out.println("Ha fallado la acción de mover el archivo");
        }
    }

    public void moveFiles(Path origenPath, Path destinoPath) {
        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo movido con éxito");
        } catch (IOException ex) {
            Logger.getLogger(NIOExamples.class.getName()).log(Level.SEVERE, "Ha fallado mover el archivo", ex);
        }
    }

    public void copyFiles(Path origenPath, Path destinoPath) {
        try {
            Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(NIOExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteFiles(Path origenPath) {
        try {
            Files.delete(origenPath);
        } catch (IOException ex) {
            Logger.getLogger(NIOExamples.class.getName()).log(Level.SEVERE, "No existe el archivo", ex);
        }

    }

    public boolean deleteIfExistsFiles(Path origenPath) {
        boolean isDelete= false;
        try {
            isDelete = Files.deleteIfExists(origenPath);
            if (isDelete) {
                System.out.println("Archivo borrado con éxito");
            } else {
                System.out.println("No existe el archivo");
            }
        } catch (IOException ex) {
            Logger.getLogger(NIOExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isDelete;
    }

}
