/**
 * Clase de reportes y estadísticas del sistema Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.reports;

import com.sakila.data.Conexion;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;

public class ReporteGeneral {

    private Connection conexion;

    /** Constructor */
    public ReporteGeneral() {
        this.conexion = Conexion.getConexion();
    }

    /**
     * Lista todos los registros de una tabla.
     * @param tabla nombre de la tabla
     */
    public void listarTabla(String tabla) {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tabla + " LIMIT 100");
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            System.out.println("\n--- REPORTE: " + tabla.toUpperCase() + " ---");
            for (int i = 1; i <= columnas; i++) {
                System.out.printf("%-20s", meta.getColumnName(i));
            }
            System.out.println();
            System.out.println("-".repeat(columnas * 20));

            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Exporta una tabla a CSV.
     * @param tabla nombre de la tabla
     */
    public void exportarCSV(String tabla) {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tabla);
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            FileWriter fw = new FileWriter(tabla + ".csv");
            for (int i = 1; i <= columnas; i++) {
                fw.write(meta.getColumnName(i));
                if (i < columnas) fw.write(",");
            }
            fw.write("\n");

            while (rs.next()) {
                for (int i = 1; i <= columnas; i++) {
                    fw.write(rs.getString(i) != null ? rs.getString(i) : "");
                    if (i < columnas) fw.write(",");
                }
                fw.write("\n");
            }
            fw.close();
            System.out.println("✅ Exportado a " + tabla + ".csv exitosamente!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Exporta una tabla a JSON.
     * @param tabla nombre de la tabla
     */
    public void exportarJSON(String tabla) {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM " + tabla);
            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            FileWriter fw = new FileWriter(tabla + ".json");
            fw.write("[\n");
            boolean primero = true;

            while (rs.next()) {
                if (!primero) fw.write(",\n");
                fw.write("  {");
                for (int i = 1; i <= columnas; i++) {
                    fw.write("\"" + meta.getColumnName(i) + "\": \"" +
                             (rs.getString(i) != null ? rs.getString(i) : "") + "\"");
                    if (i < columnas) fw.write(", ");
                }
                fw.write("}");
                primero = false;
            }
            fw.write("\n]");
            fw.close();
            System.out.println("✅ Exportado a " + tabla + ".json exitosamente!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Estadísticas de películas en inventario.
     */
    public void estadisticasInventario() {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT f.title, COUNT(i.inventory_id) as total " +
                "FROM film f JOIN inventory i ON f.film_id = i.film_id " +
                "GROUP BY f.title ORDER BY total DESC LIMIT 10"
            );
            System.out.println("\n--- TOP 10 PELÍCULAS EN INVENTARIO ---");
            System.out.printf("%-40s %-10s%n", "PELÍCULA", "CANTIDAD");
            System.out.println("-".repeat(50));
            while (rs.next()) {
                System.out.printf("%-40s %-10s%n",
                    rs.getString("title"), rs.getString("total"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Estadísticas de rentas por cliente.
     */
    public void estadisticasRentasPorCliente() {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT c.first_name, c.last_name, COUNT(r.rental_id) as total " +
                "FROM customer c JOIN rental r ON c.customer_id = r.customer_id " +
                "GROUP BY c.customer_id ORDER BY total DESC LIMIT 10"
            );
            System.out.println("\n--- TOP 10 CLIENTES CON MÁS RENTAS ---");
            System.out.printf("%-30s %-10s%n", "CLIENTE", "RENTAS");
            System.out.println("-".repeat(40));
            while (rs.next()) {
                System.out.printf("%-30s %-10s%n",
                    rs.getString("first_name") + " " + rs.getString("last_name"),
                    rs.getString("total"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Estadísticas de pagos por cliente.
     */
    public void estadisticasPagosPorCliente() {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT c.first_name, c.last_name, " +
                "COUNT(p.payment_id) as total_pagos, " +
                "SUM(p.amount) as total_monto, " +
                "AVG(p.amount) as promedio " +
                "FROM customer c JOIN payment p ON c.customer_id = p.customer_id " +
                "GROUP BY c.customer_id ORDER BY total_monto DESC LIMIT 10"
            );
            System.out.println("\n--- TOP 10 CLIENTES POR PAGOS ---");
            System.out.printf("%-30s %-10s %-12s %-10s%n",
                "CLIENTE", "PAGOS", "TOTAL", "PROMEDIO");
            System.out.println("-".repeat(65));
            while (rs.next()) {
                System.out.printf("%-30s %-10s $%-11s $%-10s%n",
                    rs.getString("first_name") + " " + rs.getString("last_name"),
                    rs.getString("total_pagos"),
                    rs.getString("total_monto"),
                    rs.getString("promedio"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Estadísticas de actores y películas.
     */
    public void estadisticasActores() {
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(
                "SELECT a.first_name, a.last_name, COUNT(fa.film_id) as peliculas " +
                "FROM actor a JOIN film_actor fa ON a.actor_id = fa.actor_id " +
                "GROUP BY a.actor_id ORDER BY peliculas DESC LIMIT 10"
            );
            System.out.println("\n--- TOP 10 ACTORES CON MÁS PELÍCULAS ---");
            System.out.printf("%-30s %-10s%n", "ACTOR", "PELÍCULAS");
            System.out.println("-".repeat(40));
            while (rs.next()) {
                System.out.printf("%-30s %-10s%n",
                    rs.getString("first_name") + " " + rs.getString("last_name"),
                    rs.getString("peliculas"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}