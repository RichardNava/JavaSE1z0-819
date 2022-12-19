/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.temario.m5io;

import java.sql.CallableStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author richa
 */
public class MyConnection {

    public void connect() throws SQLException {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos");
                Statement stm = con.createStatement()) {
            String sql = "select v.id_videojuego, v.nombre as videojuego, v.año_lanzamiento, d.nombre as desarrolladora\n"
                    + "from videojuegos v\n"
                    + "inner join desarrolladoras d on v.id_desarrolladora = d.id_desarrolladora;";
            stm.execute(sql);
            ResultSet rs = stm.getResultSet();
            while (rs.next()) {
                System.out.println("ID: "+rs.getInt(1) + " Nombre: " + rs.getString(2) + " Año: " + rs.getInt(3) + " Desarrolladora: " + rs.getString(4));
                System.out.println("Generos:");
                getGenres(rs.getInt(1)).forEach(v -> System.out.println("\t"+v));
                System.out.println("-------------------------------");
            }
        }
    }

    public List<String> getGenres(int id) {
        List<String> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/videojuegos");
                CallableStatement cstm = con.prepareCall("{CALL videojuegos.obtener_genero_por_videojuego(?)}")) {
            cstm.setInt(1, id);
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
