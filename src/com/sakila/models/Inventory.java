/**
 * Modelo que representa la tabla inventory de Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.models;

public class Inventory {

    private int inventoryId;
    private int filmId;
    private int storeId;
    private String lastUpdate;

    /** Constructor vacío */
    public Inventory() {}

    /** Constructor con parámetros */
    public Inventory(int inventoryId, int filmId, int storeId, String lastUpdate) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    // Getters y Setters
    public int getInventoryId() { return inventoryId; }
    public void setInventoryId(int inventoryId) { this.inventoryId = inventoryId; }

    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public int getStoreId() { return storeId; }
    public void setStoreId(int storeId) { this.storeId = storeId; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    /** @return String con los datos del inventario */
    @Override
    public String toString() {
        return "Inventory [ID=" + inventoryId + ", Pelicula=" + filmId +
               ", Tienda=" + storeId + "]";
    }
}