/**
 * Controlador que gestiona las operaciones de Rental.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.controllers;

import com.sakila.data.RentalDAO;
import com.sakila.models.Rental;
import java.util.List;

public class RentalController {

    private RentalDAO rentalDAO;

    /** Constructor */
    public RentalController() {
        this.rentalDAO = new RentalDAO();
    }

    /**
     * Agrega una nueva renta.
     * @param rentalDate Fecha de renta
     * @param inventoryId ID del inventario
     * @param customerId ID del cliente
     * @param returnDate Fecha de devolución
     * @param staffId ID del empleado
     * @return true si fue exitoso
     */
    public boolean agregar(String rentalDate, int inventoryId, int customerId,
                           String returnDate, int staffId) {
        Rental rental = new Rental();
        rental.setRentalDate(rentalDate);
        rental.setInventoryId(inventoryId);
        rental.setCustomerId(customerId);
        rental.setReturnDate(returnDate);
        rental.setStaffId(staffId);
        return rentalDAO.post(rental);
    }

    /**
     * Actualiza una renta existente.
     * @param rental objeto Rental a actualizar
     * @return true si fue exitoso
     */
    public boolean actualizar(Rental rental) {
        return rentalDAO.put(rental);
    }

    /**
     * Elimina una renta por su ID.
     * @param id ID de la renta
     * @return true si fue exitoso
     */
    public boolean eliminar(int id) {
        return rentalDAO.delete(id);
    }

    /**
     * Busca una renta por su ID.
     * @param id ID de la renta
     * @return Rental encontrado o null
     */
    public Rental buscar(int id) {
        return rentalDAO.get(id);
    }

    /**
     * Obtiene todas las rentas.
     * @return Lista de rentas
     */
    public List<Rental> listarTodos() {
        return rentalDAO.getAll();
    }
}