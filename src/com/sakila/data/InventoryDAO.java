/**
 * Clase hija concreta que gestiona el CRUD de la tabla inventory.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import com.sakila.models.Inventory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class InventoryDAO extends DataContext implements IDataPost<Inventory> {

    /**
     * Inserta un nuevo inventario.
     * @param inventory objeto Inventory a insertar
     * @return true si fue exitoso
     */
    @Override
    public boolean post(Inventory inventory) {
        String sql = "INSERT INTO inventory (film_id, store_id) VALUES (?, ?)";
        return ejecutarActualizacion(sql,
            inventory.getFilmId(), inventory.getStoreId());
    }

    /**
     * Actualiza un inventario existente.
     * @param inventory objeto Inventory a actualizar
     * @return true si fue exitoso
     */
    @Override
    public boolean put(Inventory inventory) {
        String sql = "UPDATE inventory SET film_id=?, store_id=? WHERE inventory_id=?";
        return ejecutarActualizacion(sql,
            inventory.getFilmId(), inventory.getStoreId(), inventory.getInventoryId());
    }

    /**
     * Elimina un inventario por su ID.
     * @param id ID del inventario
     * @return true si fue exitoso
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM inventory WHERE inventory_id=?";
        return ejecutarActualizacion(sql, id);
    }

    /**
     * Obtiene un inventario por su ID.
     * @param id ID del inventario
     * @return Inventory encontrado o null
     */
    @Override
    public Inventory get(int id) {
        String sql = "SELECT * FROM inventory WHERE inventory_id=?";
        ResultSet rs = ejecutarConsulta(sql, id);
        try {
            if (rs != null && rs.next()) {
                return new Inventory(
                    rs.getInt("inventory_id"),
                    rs.getInt("film_id"),
                    rs.getInt("store_id"),
                    rs.getString("last_update")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todos los inventarios.
     * @return Lista de inventarios
     */
    @Override
    public List<Inventory> getAll() {
        String sql = "SELECT * FROM inventory";
        ResultSet rs = ejecutarConsulta(sql);
        List<Inventory> lista = new ArrayList<>();
        try {
            while (rs != null && rs.next()) {
                lista.add(new Inventory(
                    rs.getInt("inventory_id"),
                    rs.getInt("film_id"),
                    rs.getInt("store_id"),
                    rs.getString("last_update")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}