/**
 * Clase de conexión a la base de datos Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "SharinaSql09#";

    /**
     * Método que crea y retorna la conexión a MySQL.
     * @return Connection objeto de conexión
     */
    public static Connection getConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println(" Conexión exitosa a Sakila!");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
        return con;
    }
}