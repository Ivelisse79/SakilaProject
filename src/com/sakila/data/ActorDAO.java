/**
 * Clase hija concreta que gestiona el CRUD de la tabla actor.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import com.sakila.models.Actor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ActorDAO extends DataContext implements IDataPost<Actor> {

    /**
     * Inserta un nuevo actor en la base de datos.
     * @param actor objeto Actor a insertar
     * @return true si fue exitoso
     */
    @Override
    public boolean post(Actor actor) {
        String sql = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        return ejecutarActualizacion(sql, actor.getFirstName(), actor.getLastName());
    }

    /**
     * Actualiza un actor existente.
     * @param actor objeto Actor a actualizar
     * @return true si fue exitoso
     */
    @Override
    public boolean put(Actor actor) {
        String sql = "UPDATE actor SET first_name=?, last_name=? WHERE actor_id=?";
        return ejecutarActualizacion(sql, actor.getFirstName(), 
                                    actor.getLastName(), actor.getActorId());
    }

    /**
     * Elimina un actor por su ID.
     * @param id ID del actor
     * @return true si fue exitoso
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM actor WHERE actor_id=?";
        return ejecutarActualizacion(sql, id);
    }

    /**
     * Obtiene un actor por su ID.
     * @param id ID del actor
     * @return Actor encontrado o null
     */
    @Override
    public Actor get(int id) {
        String sql = "SELECT * FROM actor WHERE actor_id=?";
        ResultSet rs = ejecutarConsulta(sql, id);
        try {
            if (rs != null && rs.next()) {
                return new Actor(
                    rs.getInt("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("last_update")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todos los actores de la base de datos.
     * @return Lista de actores
     */
    @Override
    public List<Actor> getAll() {
        String sql = "SELECT * FROM actor";
        ResultSet rs = ejecutarConsulta(sql);
        List<Actor> lista = new ArrayList<>();
        try {
            while (rs != null && rs.next()) {
                lista.add(new Actor(
                    rs.getInt("actor_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("last_update")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}