/**
 * Controlador que gestiona las operaciones de Actor.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.controllers;

import com.sakila.data.ActorDAO;
import com.sakila.models.Actor;
import java.util.List;

public class ActorController {

    private ActorDAO actorDAO;

    /** Constructor */
    public ActorController() {
        this.actorDAO = new ActorDAO();
    }

    /**
     * Agrega un nuevo actor.
     * @param firstName Nombre
     * @param lastName Apellido
     * @return true si fue exitoso
     */
    public boolean agregar(String firstName, String lastName) {
        Actor actor = new Actor();
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        return actorDAO.post(actor);
    }

    /**
     * Actualiza un actor existente.
     * @param id ID del actor
     * @param firstName Nombre
     * @param lastName Apellido
     * @return true si fue exitoso
     */
    public boolean actualizar(int id, String firstName, String lastName) {
        Actor actor = new Actor();
        actor.setActorId(id);
        actor.setFirstName(firstName);
        actor.setLastName(lastName);
        return actorDAO.put(actor);
    }

    /**
     * Elimina un actor por su ID.
     * @param id ID del actor
     * @return true si fue exitoso
     */
    public boolean eliminar(int id) {
        return actorDAO.delete(id);
    }

    /**
     * Busca un actor por su ID.
     * @param id ID del actor
     * @return Actor encontrado o null
     */
    public Actor buscar(int id) {
        return actorDAO.get(id);
    }

    /**
     * Obtiene todos los actores.
     * @return Lista de actores
     */
    public List<Actor> listarTodos() {
        return actorDAO.getAll();
    }
}