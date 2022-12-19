/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m6streams;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author richa
 */
public class DBConnect {

    public Properties loadProps(Path p) throws FileNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream(new File(p.toAbsolutePath().toString()))) {
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }
    }

    public void createMovie(Movie m) throws IOException, SQLException {
        Properties prop = loadProps(Paths.get("src\\com\\femxa\\db\\configuration.properties"));
        try (Connection con = DriverManager.getConnection(prop.get("URL").toString())) {
            String sql = "INSERT INTO MOVIES (title,director,genre,pegi,launchyear,rating,awards,watched) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, m.getTitle());
            stm.setString(2, m.getDirector());
            stm.setString(3, m.getGenre().name());
            stm.setString(4, m.getPegi().name());
            stm.setInt(5, m.getYear());
            stm.setDouble(6, m.getRating());
            stm.setBoolean(7, m.isAwards());
            stm.setBoolean(8, m.isWatched());

            stm.execute();
        }
    }

    public Set<Movie> readAllMovies() throws IOException, SQLException {
        Set<Movie> movies = new HashSet<>();
        Properties prop = loadProps(Paths.get("src\\com\\femxa\\db\\configuration.properties"));
        try (Connection con = DriverManager.getConnection(prop.get("URL").toString())) {
            String sql = "SELECT * FROM MOVIES";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {                
                movies.add(new Movie(
                        rs.getString(2),
                        rs.getString(3),
                        Genre.valueOf(rs.getString(4)),
                        PEGI.valueOf(rs.getString(5)),
                        rs.getInt(6),
                        rs.getDouble(7),
                        rs.getBoolean(8),
                        rs.getBoolean(9)
                ));
            }
            return movies;
        }
    }
}
