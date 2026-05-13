/**
 * Clase abstracta padre que gestiona la conexión a la base de datos.
 * Los hijos no pueden modificar los métodos de conexión.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DataContext {

    /** Conexión a la base de datos - no puede ser modificada por los hijos */
    private final Connection conexion;

    /**
     * Constructor que establece la conexión automáticamente.
     */
    public DataContext() {
        this.conexion = Conexion.getConexion();
    }

    /**
     * Método final - los hijos NO pueden cambiar esto.
     * @return Connection objeto de conexión
     */
    protected final Connection getConexion() {
        return conexion;
    }

    /**
     * Ejecuta una consulta SQL y retorna resultados.
     * Método final - los hijos NO pueden cambiar esto.
     * @param sql consulta SQL
     * @param params parámetros de la consulta
     * @return ResultSet con los resultados
     */
    protected final ResultSet ejecutarConsulta(String sql, Object... params) {
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error en consulta: " + e.getMessage());
            return null;
        }
    }

    /**
     * Ejecuta una actualización SQL (INSERT, UPDATE, DELETE).
     * Método final - los hijos NO pueden cambiar esto.
     * @param sql consulta SQL
     * @param params parámetros de la consulta
     * @return true si fue exitoso
     */
    protected final boolean ejecutarActualizacion(String sql, Object... params) {
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error en actualización: " + e.getMessage());
            return false;
        }
    }
}