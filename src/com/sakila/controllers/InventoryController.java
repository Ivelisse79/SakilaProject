/**
 * Controlador que gestiona las operaciones de Inventory.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.controllers;

import com.sakila.data.InventoryDAO;
import com.sakila.models.Inventory;
import java.util.List;

public class InventoryController {

    private InventoryDAO inventoryDAO;

    /** Constructor */
    public InventoryController() {
        this.inventoryDAO = new InventoryDAO();
    }

    /**
     * Agrega un nuevo inventario.
     * @param filmId ID de la película
     * @param storeId ID de la tienda
     * @return true si fue exitoso
     */
    public boolean agregar(int filmId, int storeId) {
        Inventory inventory = new Inventory();
        inventory.setFilmId(filmId);
        inventory.setStoreId(storeId);
        return inventoryDAO.post(inventory);
    }

    /**
     * Actualiza un inventario existente.
     * @param inventory objeto Inventory a actualizar
     * @return true si fue exitoso
     */
    public boolean actualizar(Inventory inventory) {
        return inventoryDAO.put(inventory);
    }

    /**
     * Elimina un inventario por su ID.
     * @param id ID del inventario
     * @return true si fue exitoso
     */
    public boolean eliminar(int id) {
        return inventoryDAO.delete(id);
    }

    /**
     * Busca un inventario por su ID.
     * @param id ID del inventario
     * @return Inventory encontrado o null
     */
    public Inventory buscar(int id) {
        return inventoryDAO.get(id);
    }

    /**
     * Obtiene todos los inventarios.
     * @return Lista de inventarios
     */
    public List<Inventory> listarTodos() {
        return inventoryDAO.getAll();
    }
}
