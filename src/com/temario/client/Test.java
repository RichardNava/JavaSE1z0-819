package com.temario.client;

import com.temario.m1datatypes.Bucles;
import com.temario.m1datatypes.DatosPrimitivos;
import com.temario.m1datatypes.EjemploStatic;
import com.temario.m1datatypes.EstructuraIf;
import com.temario.m1datatypes.EstructurasControl;
import com.temario.m1datatypes.StringVSStringBuilder;
import com.temario.m2poo.Externa;
import com.temario.m2poo.Externa.Interna.Interna2;
import com.temario.m2poo.Externa.Interna.Interna2.Interna3;
import com.temario.m2poo.Externa.Interna.Interna2.Interna3.Interna4;
import com.temario.m3collections.ArrayExamples;
import com.temario.m3collections.Book;
import com.temario.m3collections.BookListManager;
import com.temario.m3collections.Matrices;
import com.temario.m4excepctions.CifradoCesar;
import com.temario.m4excepctions.EjemploTryCatch;
import com.temario.m4excepctions.EjemploTryWithResources;
import com.temario.m5io.IOExamples;
import com.temario.m5io.LibraryManager;
import com.temario.m5io.NIOExamples;
import com.temario.m5io.SerializableDemo;
import com.temario.m5io.Vehicle;
import com.temario.m6streams.Fibonacci;
import com.temario.m6streams.Genre;
import com.temario.m6streams.Movie;
import com.temario.m6streams.MovieManager;
import com.temario.m7concurrency.TestConcurrency;
import com.temario.m8others.MostrarFecha;
import com.temario.m8others.PropertiesLocaleExample;
import com.temario.m8others.UseAnnotation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// DESCOMENTA LAS LINEAS DE CÓDIGO QUE QUIERAS PROBAR
public class Test {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in);
                InputStreamReader in = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(in)) {

// --- Mostrar Datos primitivos ---
//            DatosPrimitivos dp = new DatosPrimitivos();
//            dp.showPrimitiveData();

// --- Mostrar para ver diferencias entre String y StringBuilder ---
//                new StringVSStringBuilder().show();

// --- Mostrar para ver comportamiento de Estructuras if
//            EstructuraIf ei = new EstructuraIf();
//                ei.compCarInicial(sc);
//                ei.definirPar(sc);
//                ei.mayorMenor(sc);

// --- Mostrar método EstructurasControl ---
//            EstructurasControl ec = new EstructurasControl();
//            ec.notasIf(sc);
//            ec.switchSemana(sc);
//            System.out.println(ec.convertCase(br, true)); //Cambiar el boolean para convertir de mayusculas->minusculas a minusculas->mayusculas
//            System.out.println(ec.reverseText(br));
//            System.out.println(ec.reverseTextSB(br));


// --- Mostrar para probar Bucles ---
//            Bucles bu = new Bucles();
//                bu.usandoDoWhile(0);
//                bu.usandoWhile(sc);
//                bu.usandoFor();

// --- Mostrar EjemploStatic para ver comportamiento de los inicializadores y miembros estáticos ---
//            EjemploStatic es = new EjemploStatic();

// --- Mostrar para ver ejemplos de instancias de clases anidadas de la clase Externa
//            Externa ext = new Externa();
//            Externa.Interna inter = new Externa().new Interna(); 
//            Externa.InternaStatic intSt = new Externa.InternaStatic();
//
//            Interna2 in2 = inter.new Interna2();
//            Interna3 in3 = in2.new Interna3();
//            Interna4 in4 = in3.new Interna4();
//            System.out.println(ext +" "+ inter +" "+ intSt +" "+ in2 +" "+ in3 +" "+ in4);

// --- Mostrar ejemplo de ArrayExamples ---
//             new ArrayExamples().ejemplos(sc);

// --- Mostrar aplicación Matrices ---
//new Matrices().maiMenu(br);

// --- Mostrar aplicación BookListManager ---
// new BookListManager(br).maiMenu(sc);

// --- Mostrar CifradoCesar que obliga a implementar try/catch ---
//            CifradoCesar cc = new CifradoCesar();
//            try {
//                String textoEncriptado = cc.cesarEncrypt(br, CifradoCesar.Mode.ENCODE); // Cambiar de módo si se quiere probar el decodificador
//                System.out.println("Texto encriptado-> "+textoEncriptado);
//                System.out.println("Texto desencriptado-> "+cc.cesarEncrypt(textoEncriptado, CifradoCesar.Mode.DECODE));
//            } catch (SQLException ex) { // Recogemos SQLException que se esta propagando a pesar de que no se puede provocar
//                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, "ESTA EXCEPCION NO SE PUEDE PROVOCAR", ex);
//            }

// --- Mostrar para ver EjemploTryCatch ---

//            EjemploTryCatch etc = new EjemploTryCatch();
//            etc.division(sc); // Introducir mal los datos para comprobar manejo de errores

// --- Mostrar ejemplo de EjemploTryWithResources ---
//        new EjemploTryWithResources().pruebaTWC();
// --- Input/Output (Entrada/Salida) ---
//            Path origenPath = Paths.get("C:\\Prueba\\CarpetaA\\Texto.txt"); // AVISO: Si no existe la ruta cambiarla por una ruta existente que contenga un archivo
//            Path destinoPath = Paths.get("C:\\Prueba\\CarpetaB\\texto.txt"); // AVISO: Si no existe la ruta cambiarla por una ruta existente que contenga un archivo
//            Charset charset = Charset.forName("ISO-8859-1");

// --- Mostrar LibraryManager para ver conceptos de IO ---
//            LibraryManager lm = new LibraryManager("C:\\Libreria\\");
//            lm.menu();

// --- Mostrar ejemplos de NIO ---
//            NIOExamples nioe = new NIOExamples();
//            nioe.demoPath();
//            nioe.copyFiles(origenPath, destinoPath);
//            nioe.deleteFiles(origenPath);
//            nioe.deleteIfExistsFiles(origenPath);
//            nioe.filesRead(origenPath, charset);
//            nioe.filesWrite(origenPath, charset, "Mensaje de prueba");
//            nioe.moveFiles(origenPath, destinoPath);
//            nioe.renameToFile(origenPath, destinoPath);

// --- Mostrar ejemplos de IO ---
//            IOExamples ioe = new IOExamples();
//            ioe.bufferedWriterExample(origenPath.toString(), "Mensajee de prueba");
//            ioe.fileWriterExample(origenPath.toString(), true, "Cosas nuevas y más cosas");
//            ioe.printStreamExample(destinoPath.toString(), "Otro mensaje de prueba adicional");


// --- Mostrar ejemplos de Serializable ---
//            SerializableDemo sd = new SerializableDemo();
//            sd.demoEmployee();
//            sd.readEmployee();
//            Vehicle v1 = new Vehicle("Renault","Clio",12345);
//            v1.serializeVehicle(v1);
//            v1.deserializeVehicle();



// --- Mostrar aplicación MovieManager (Streams) ---
//            MovieManager mm = new MovieManager();
//            List<Movie> movies = mm.createMovieList(); 
//            mm.insertMovieData(); // AVISO: Debe crear la base de datos con los recursos facilitados en com.temario.m6streams para que funcione. URL -> jdbc:derby://localhost:1527/dbmovies
//            mm.findByGenre(Genre.TERROR).forEach(System.out::println); // AVISO: Debe crear la base de datos con los recursos facilitados en com.temario.m6streams para que funcione. URL -> jdbc:derby://localhost:1527/dbmovies
//            mm.topTenAwardedMovies(movies).forEach(System.out::println);
//            mm.averageRatingMovies(movies);
//            mm.tablaPremios().forEach((k,v) -> System.out.println(k+" "+v));
//            mm.findByGenre(Genre.TERROR).forEach(System.out::print);
//            mm.movieRating(movies, 1965, 1985);
//            mm.peliculasAutorizadas13(movies);
//            String director = "David Fincher";
//            System.out.println("La media de valoración de las péliculas de "+director+" es: "+mm.findMediaDirector(movies, director));
//            System.out.println(mm.isPassed(movies.get(8)));

// --- Mostrar aplicación Fibonacci (Streams) ---
//            Fibonacci fib = new Fibonacci();
//            fib.secuenciaFibonacci();
//            fib.FibonacciSequence(2,10).forEach(System.out::println);

// --- Mostrar ejemplos de Concurrencia --- AVISO: Debes crear unos archivos de texto en la siguiente ruta -> C:\\Prueba\\Textos\\numeros.txt (que contega números en cada linea) y añadir más archivos de tipo .txt que contenga colores en cada linea
//            TestConcurrency tc = new TestConcurrency();
//            tc.testConcurrency();

// --- Mostrar ejemplo de anotaciones ---
//            new UseAnnotation().use(new MostrarFecha());

// --- Mostrar ejemplo de Locale + Properties ---
//            Locale[] locales = {new Locale("es","ES"),Locale.US,Locale.FRANCE};
//            PropertiesLocaleExample ple = new PropertiesLocaleExample(locales[2]);
//            ple.saludar();
//            ple.saludar("Manolo");
//            ple.despedir();
//            ple.despedir("Silvia");
//            ple.moneda(10);
//            ple.fecha(LocalDate.of(1981, Month.NOVEMBER, 28));
//            ple.region();
            

        } catch (NumberFormatException | InputMismatchException e) {
            System.out.println("No ha introducido un número correcto.");
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, "Error en la entrada de datos", ex);
        }
        catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, "Error en la espera u otra excepción", ex);
        }
    }

}
