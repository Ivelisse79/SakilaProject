/**
 * Controlador que gestiona las operaciones de Customer.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.controllers;

import com.sakila.data.CustomerDAO;
import com.sakila.models.Customer;
import java.util.List;

public class CustomerController {

    private CustomerDAO customerDAO;

    /** Constructor */
    public CustomerController() {
        this.customerDAO = new CustomerDAO();
    }

    /**
     * Agrega un nuevo cliente.
     * @param storeId ID de la tienda
     * @param firstName Nombre
     * @param lastName Apellido
     * @param email Correo electrónico
     * @param addressId ID de la dirección
     * @param active Estado activo
     * @return true si fue exitoso
     */
    public boolean agregar(int storeId, String firstName, String lastName,
                           String email, int addressId, boolean active) {
        Customer customer = new Customer();
        customer.setStoreId(storeId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAddressId(addressId);
        customer.setActive(active);
        return customerDAO.post(customer);
    }

    /**
     * Actualiza un cliente existente.
     * @param customer objeto Customer a actualizar
     * @return true si fue exitoso
     */
    public boolean actualizar(Customer customer) {
        return customerDAO.put(customer);
    }

    /**
     * Elimina un cliente por su ID.
     * @param id ID del cliente
     * @return true si fue exitoso
     */
    public boolean eliminar(int id) {
        return customerDAO.delete(id);
    }

    /**
     * Busca un cliente por su ID.
     * @param id ID del cliente
     * @return Customer encontrado o null
     */
    public Customer buscar(int id) {
        return customerDAO.get(id);
    }

    /**
     * Obtiene todos los clientes.
     * @return Lista de clientes
     */
    public List<Customer> listarTodos() {
        return customerDAO.getAll();
    }
}