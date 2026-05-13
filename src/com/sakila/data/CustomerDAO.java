/**
 * Clase hija concreta que gestiona el CRUD de la tabla customer.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import com.sakila.models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CustomerDAO extends DataContext implements IDataPost<Customer> {

    /**
     * Inserta un nuevo cliente.
     * @param customer objeto Customer a insertar
     * @return true si fue exitoso
     */
    @Override
    public boolean post(Customer customer) {
        String sql = "INSERT INTO customer (store_id, first_name, last_name, " +
                     "email, address_id, active) VALUES (?, ?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            customer.getStoreId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail(), customer.getAddressId(), customer.isActive());
    }

    /**
     * Actualiza un cliente existente.
     * @param customer objeto Customer a actualizar
     * @return true si fue exitoso
     */
    @Override
    public boolean put(Customer customer) {
        String sql = "UPDATE customer SET store_id=?, first_name=?, last_name=?, " +
                     "email=?, address_id=?, active=? WHERE customer_id=?";
        return ejecutarActualizacion(sql,
            customer.getStoreId(), customer.getFirstName(), customer.getLastName(),
            customer.getEmail(), customer.getAddressId(), customer.isActive(),
            customer.getCustomerId());
    }

    /**
     * Elimina un cliente por su ID.
     * @param id ID del cliente
     * @return true si fue exitoso
     */
    @Override
    public boolean delete(int id) {
        try {
            // Primero eliminamos los pagos del cliente
            ejecutarActualizacion("DELETE FROM payment WHERE customer_id=?", id);
            // Luego eliminamos las rentas del cliente
            ejecutarActualizacion("DELETE FROM rental WHERE customer_id=?", id);
            // Finalmente eliminamos el cliente
            return ejecutarActualizacion("DELETE FROM customer WHERE customer_id=?", id);
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }
    }
    /**
     * Obtiene un cliente por su ID.
     * @param id ID del cliente
     * @return Customer encontrado o null
     */
    @Override
    public Customer get(int id) {
        String sql = "SELECT * FROM customer WHERE customer_id=?";
        ResultSet rs = ejecutarConsulta(sql, id);
        try {
            if (rs != null && rs.next()) {
                return new Customer(
                    rs.getInt("customer_id"),
                    rs.getInt("store_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getInt("address_id"),
                    rs.getBoolean("active"),
                    rs.getString("create_date"),
                    rs.getString("last_update")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todos los clientes.
     * @return Lista de clientes
     */
    @Override
    public List<Customer> getAll() {
        String sql = "SELECT * FROM customer";
        ResultSet rs = ejecutarConsulta(sql);
        List<Customer> lista = new ArrayList<>();
        try {
            while (rs != null && rs.next()) {
                lista.add(new Customer(
                    rs.getInt("customer_id"),
                    rs.getInt("store_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getInt("address_id"),
                    rs.getBoolean("active"),
                    rs.getString("create_date"),
                    rs.getString("last_update")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}