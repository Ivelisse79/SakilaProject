/**
 * Modelo que representa la tabla actor de Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.models;

public class Actor {

    // Atributos - igual que las columnas de la tabla
    private int actorId;
    private String firstName;
    private String lastName;
    private String lastUpdate;

    /**
     * Constructor vacío
     */
    public Actor() {}

    /**
     * Constructor con parámetros
     * @param actorId ID del actor
     * @param firstName Nombre
     * @param lastName Apellido
     * @param lastUpdate Fecha actualización
     */
    public Actor(int actorId, String firstName, String lastName, String lastUpdate) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;
    }

    // Getters y Setters
    public int getActorId() { return actorId; }
    public void setActorId(int actorId) { this.actorId = actorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    /**
     * Muestra los datos del actor como texto
     * @return String con los datos
     */
    @Override
    public String toString() {
        return "Actor [ID=" + actorId + ", Nombre=" + firstName + " " + lastName + "]";
    }
}