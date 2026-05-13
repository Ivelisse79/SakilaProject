/**
 * Clase hija concreta que gestiona el CRUD de la tabla rental.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import com.sakila.models.Rental;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class RentalDAO extends DataContext implements IDataPost<Rental> {

    /**
     * Inserta una nueva renta.
     * @param rental objeto Rental a insertar
     * @return true si fue exitoso
     */
    @Override
    public boolean post(Rental rental) {
        String sql = "INSERT INTO rental (rental_date, inventory_id, customer_id, " +
                     "return_date, staff_id) VALUES (?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            rental.getRentalDate(), rental.getInventoryId(), rental.getCustomerId(),
            rental.getReturnDate(), rental.getStaffId());
    }

    /**
     * Actualiza una renta existente.
     * @param rental objeto Rental a actualizar
     * @return true si fue exitoso
     */
    @Override
    public boolean put(Rental rental) {
        String sql = "UPDATE rental SET rental_date=?, inventory_id=?, customer_id=?, " +
                     "return_date=?, staff_id=? WHERE rental_id=?";
        return ejecutarActualizacion(sql,
            rental.getRentalDate(), rental.getInventoryId(), rental.getCustomerId(),
            rental.getReturnDate(), rental.getStaffId(), rental.getRentalId());
    }

    /**
     * Elimina una renta por su ID.
     * @param id ID de la renta
     * @return true si fue exitoso
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM rental WHERE rental_id=?";
        return ejecutarActualizacion(sql, id);
    }

    /**
     * Obtiene una renta por su ID.
     * @param id ID de la renta
     * @return Rental encontrado o null
     */
    @Override
    public Rental get(int id) {
        String sql = "SELECT * FROM rental WHERE rental_id=?";
        ResultSet rs = ejecutarConsulta(sql, id);
        try {
            if (rs != null && rs.next()) {
                return new Rental(
                    rs.getInt("rental_id"),
                    rs.getString("rental_date"),
                    rs.getInt("inventory_id"),
                    rs.getInt("customer_id"),
                    rs.getString("return_date"),
                    rs.getInt("staff_id"),
                    rs.getString("last_update")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todas las rentas.
     * @return Lista de rentas
     */
    @Override
    public List<Rental> getAll() {
        String sql = "SELECT * FROM rental";
        ResultSet rs = ejecutarConsulta(sql);
        List<Rental> lista = new ArrayList<>();
        try {
            while (rs != null && rs.next()) {
                lista.add(new Rental(
                    rs.getInt("rental_id"),
                    rs.getString("rental_date"),
                    rs.getInt("inventory_id"),
                    rs.getInt("customer_id"),
                    rs.getString("return_date"),
                    rs.getInt("staff_id"),
                    rs.getString("last_update")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}