/**
 * Controlador que gestiona las operaciones de Payment.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.controllers;

import com.sakila.data.PaymentDAO;
import com.sakila.models.Payment;
import java.util.List;

public class PaymentController {

    private PaymentDAO paymentDAO;

    /** Constructor */
    public PaymentController() {
        this.paymentDAO = new PaymentDAO();
    }

    /**
     * Agrega un nuevo pago.
     * @param customerId ID del cliente
     * @param staffId ID del empleado
     * @param rentalId ID de la renta
     * @param amount Monto
     * @param paymentDate Fecha de pago
     * @return true si fue exitoso
     */
    public boolean agregar(int customerId, int staffId, int rentalId,
                           double amount, String paymentDate) {
        Payment payment = new Payment();
        payment.setCustomerId(customerId);
        payment.setStaffId(staffId);
        payment.setRentalId(rentalId);
        payment.setAmount(amount);
        payment.setPaymentDate(paymentDate);
        return paymentDAO.post(payment);
    }

    /**
     * Actualiza un pago existente.
     * @param payment objeto Payment a actualizar
     * @return true si fue exitoso
     */
    public boolean actualizar(Payment payment) {
        return paymentDAO.put(payment);
    }

    /**
     * Elimina un pago por su ID.
     * @param id ID del pago
     * @return true si fue exitoso
     */
    public boolean eliminar(int id) {
        return paymentDAO.delete(id);
    }

    /**
     * Busca un pago por su ID.
     * @param id ID del pago
     * @return Payment encontrado o null
     */
    public Payment buscar(int id) {
        return paymentDAO.get(id);
    }

    /**
     * Obtiene todos los pagos.
     * @return Lista de pagos
     */
    public List<Payment> listarTodos() {
        return paymentDAO.getAll();
    }
}