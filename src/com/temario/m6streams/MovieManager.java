package com.temario.m6streams;


import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieManager {

    public List<Movie> createMovieList() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Cadena Perpetua", "Frank Darabont", Genre.DRAMA, PEGI.PLUS16, 1994, 8.9, true, true));
        movieList.add(new Movie("Forrest Gump", "Robert Zemeckis", Genre.DRAMA, PEGI.PLUS13, 1994, 8.9, true, true));
        movieList.add(new Movie("Los Odiosos 8", "Quentin Tarantino", Genre.WESTERN, PEGI.PLUS18, 2015, 7.3, true, true));
        movieList.add(new Movie("Sin Perdon", "Clint Eastwood", Genre.WESTERN, PEGI.PLUS16, 1992, 8.2, true, true));
        movieList.add(new Movie("2001: Una odisea del espacio", "Stanley Kubrik", Genre.CIENCIA_FICCION, PEGI.PLUS13, 1994, 8.3, true, true));
        movieList.add(new Movie("Aguirre la cólera de Dios", "Werner Herzog", Genre.AVENTURAS, PEGI.PLUS18, 1972, 7.2, true, true));
        movieList.add(new Movie("Toy Story", "John Lasseter", Genre.ANIMACION, PEGI.ALL, 1995, 8.3, true, true));
        movieList.add(new Movie("Manos: The Hands of Fate", "Harold P.Warren", Genre.TERROR, PEGI.PLUS18, 1966, 1.6, false, false));
        movieList.add(new Movie("Campo de Batalla: La Tierra", "Jonathan Liebesman", Genre.CIENCIA_FICCION, PEGI.ALL, 2000, 2.5, false, true));
        movieList.add(new Movie("¡Mira quien habla ahora!", "Tom Ropelewski", Genre.COMEDIA, PEGI.ALL, 2004, 3.1, false, true));
        movieList.add(new Movie("El club de la lucha", "David Fincher", Genre.THRILLER, PEGI.PLUS16, 1999, 8.8, false, true));
        movieList.add(new Movie("Sucedió en Manhattan", "Wayne Wang", Genre.ROMANTICA, PEGI.ALL, 2002, 4.3, false, false));
        movieList.add(new Movie("Deseando amar", "Wong Kar-wai", Genre.ROMANTICA, PEGI.ALL, 2000, 7.8, true, true));
        movieList.add(new Movie("El Apartamento", "Billy Wilder", Genre.COMEDIA, PEGI.ALL, 1960, 8.4, true, true));
        movieList.add(new Movie("Apocalypse Now", "Francis Ford Coppola", Genre.BELICA, PEGI.PLUS18, 1979, 8.5, true, true));
        movieList.add(new Movie("El crepusculo de los dioses", "Billy Wilder", Genre.DRAMA, PEGI.PLUS13, 1950, 8.5, true, true));
        movieList.add(new Movie("Shrek 2", "Grant Duffrin", Genre.ANIMACION, PEGI.ALL, 2004, 7.9, false, true));
        movieList.add(new Movie("Piratas del Caribe: La maldición de la perla negra", "Gore Verbinski", Genre.AVENTURAS, PEGI.ALL, 2003, 8.1, false, true));
        movieList.add(new Movie("Seven", "David Fincher", Genre.THRILLER, PEGI.PLUS16, 1995, 8.3, false, true));
        movieList.add(new Movie("El resplandor", "Stanley Kubrik", Genre.TERROR, PEGI.PLUS18, 1980, 8.4, false, true));
        movieList.add(new Movie("Pulp Fiction", "Quentin Tarantino", Genre.THRILLER, PEGI.PLUS16, 1994, 8.9, true, true));
        movieList.add(new Movie("Acorralado", "Ted Kotcheff", Genre.ACCION, PEGI.PLUS18, 1982, 6.6, false, true));
        movieList.add(new Movie("Tango y Cash", "Andrei Konchalovsky", Genre.ACCION, PEGI.PLUS16, 1989, 5.3, false, true));
        movieList.add(new Movie("Ciudadano Kane", "Orson Welles", Genre.DRAMA, PEGI.PLUS13, 1941, 8.3, true, true));
        movieList.add(new Movie("Crepusculo", "Bill Condon", Genre.ROMANTICA, PEGI.ALL, 1994, 4.9, false, false));
        movieList.add(new Movie("La chaqueta metalica", "Stanley Kubrik", Genre.BELICA, PEGI.PLUS18, 1987, 8.3, false, true));
        movieList.add(new Movie("Terciopelo Azul", "David Lynch", Genre.THRILLER, PEGI.PLUS18, 1986, 7.4, false, true));
        movieList.add(new Movie("Cars 2", "John Lasseter", Genre.ANIMACION, PEGI.ALL, 2011, 6.2, false, false));
        movieList.add(new Movie("Star Wars: Episodio IV - Una nueva esperanza", "George Lucas", Genre.CIENCIA_FICCION, PEGI.PLUS13, 1977, 8.6, false, true));
        movieList.add(new Movie("Regreso al futuro", "Robert Zemeckis", Genre.CIENCIA_FICCION, PEGI.ALL, 1985, 7.5, false, true));
        movieList.add(new Movie("Alien: el octavo pasajero", "Ridley Scott", Genre.CIENCIA_FICCION, PEGI.PLUS16, 1979, 8.1, false, true));
        movieList.add(new Movie("American Beauty", "Sam Mendes", Genre.DRAMA, PEGI.PLUS13, 1999, 7.9, true, true));
        movieList.add(new Movie("Una noche en la opera", "Sam Wood", Genre.COMEDIA, PEGI.ALL, 1935, 8.3, false, true));
        movieList.add(new Movie("La lista de Schindler", "Steven Spielberg", Genre.BELICA, PEGI.PLUS13, 1993, 8.7, true, true));
        movieList.add(new Movie("Indiana Jones: En busca del arca perdida", "Steven Spielberg", Genre.AVENTURAS, PEGI.ALL, 1981, 8.6, false, true));
        movieList.add(new Movie("Los Goonies", "Steven Spielberg", Genre.AVENTURAS, PEGI.ALL, 1985, 7.3, false, true));
        movieList.add(new Movie("El padrino", "Francis Ford Coppola", Genre.DRAMA, PEGI.PLUS16, 1972, 9, true, true));
        movieList.add(new Movie("West Side Story", "Robert Wise", Genre.ROMANTICA, PEGI.PLUS13, 1961, 7.3, false, true));
        movieList.add(new Movie("Big Fish", "Tim Burton", Genre.DRAMA, PEGI.ALL, 2003, 7.9, false, true));
        movieList.add(new Movie("Eduardo Manostijeras", "Tim Burton", Genre.ROMANTICA, PEGI.ALL, 1990, 6.9, false, true));
        movieList.add(new Movie("La diligencia", "John Ford", Genre.WESTERN, PEGI.PLUS16, 1939, 8, true, true));

        return movieList;

    }

    public void insertMovieData() { // Solo disponible si hay base de datos
        DBConnect dbconn = new DBConnect();
        createMovieList().stream().forEach(m -> {
            try {
                dbconn.createMovie(m);
            } catch (IOException ex) {
                Logger.getLogger(MovieManager.class.getName()).log(Level.SEVERE, "No se ha encontrado el archivo", ex);
            } catch (SQLException ex) {
                Logger.getLogger(MovieManager.class.getName()).log(Level.SEVERE, "Excepcion de SQL", ex);
            }
        });
    }

    public List<Movie> findByGenre(Genre genre) { // Solo disponible si hay base de datos
        DBConnect dbconn = new DBConnect();
        List<Movie> movies = null;
        try {
            movies = dbconn.readAllMovies().stream()
                    .filter(mov -> mov.getGenre().name().equals(genre.name()))
                    .collect(Collectors.toList());
        } catch (IOException | SQLException ex) {
            Logger.getLogger(MovieManager.class.getName()).log(Level.SEVERE, "Error en la conexión", ex);
        }
        return movies;
    }

    public double averageRatingMovies(Collection<Movie> movies) {
        double avg = movies.stream()
                .mapToDouble(mov -> mov.getRating())
                .average()
                .orElse(0);
        System.out.println("La media de valoración de las peliculas seleccionadas es: " + new DecimalFormat("#.00").format(avg));
        return avg;

    }

    public List<Movie> topTenAwardedMovies(Collection<Movie> movies) {
        return movies.stream().filter(m -> m.isAwards())
                .sorted((m1, m2) -> (int) (m2.getRating() * 10) - (int) (m1.getRating() * 10))
                .limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public double findMediaDirector(Collection<Movie> movies, String director) {

        return movies.stream().filter(m -> m.getDirector().equals(director))
                .peek(m -> System.out.println(m))
                .mapToDouble(m -> m.getRating())
                .max()
                .getAsDouble();
    }

    public Map<Boolean, List<Movie>> tablaPremios() {
        return createMovieList()
                .stream()
                .map(m -> {
                    if (m.getDirector().contains("Tarantino")) {
                        m.setAwards(false);
                    }
                    return m;
                })
                .collect(Collectors.partitioningBy(m -> m.isAwards()));
    }

    public List<Movie> peliculasAutorizadas13(Collection<Movie> movies) {
        return movies.stream()
                .filter(n -> n.getPegi().ordinal() < 2)
                .peek(m -> System.out.println(m))
                .collect(Collectors.toList());

    }


    public boolean movieRating(Collection<Movie> movies, int yearStart, int yearEnd) {
        return movies.parallelStream()
                .filter(n -> n.getYear() >= yearStart && n.getYear() <= yearEnd)
                .sorted((a, b) -> (int) (b.getRating() * 10) - (int) (a.getRating() * 10))
                .peek(MovieManager::showData)
                .anyMatch(new MovieManager()::isPassed);
    }
    
    public boolean isPassed(Movie m){
        return m.getRating() >= 5;
    }
    public static void showData(Movie m){
        System.out.println(m.toString());
    }
    public long charsWhitReferenceMethod(){
        List<Character> list = new ArrayList<>(Arrays.asList('a','1','@','b'));
        return list.stream()
            .filter(Character::isLetter)
            .count();
    }
    

}
