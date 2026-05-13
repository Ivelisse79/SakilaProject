/**
 * Clase hija concreta que gestiona el CRUD de la tabla payment.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.data;

import com.sakila.models.Payment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class PaymentDAO extends DataContext implements IDataPost<Payment> {

    /**
     * Inserta un nuevo pago.
     * @param payment objeto Payment a insertar
     * @return true si fue exitoso
     */
    @Override
    public boolean post(Payment payment) {
        String sql = "INSERT INTO payment (customer_id, staff_id, rental_id, " +
                     "amount, payment_date) VALUES (?, ?, ?, ?, ?)";
        return ejecutarActualizacion(sql,
            payment.getCustomerId(), payment.getStaffId(), payment.getRentalId(),
            payment.getAmount(), payment.getPaymentDate());
    }

    /**
     * Actualiza un pago existente.
     * @param payment objeto Payment a actualizar
     * @return true si fue exitoso
     */
    @Override
    public boolean put(Payment payment) {
        String sql = "UPDATE payment SET customer_id=?, staff_id=?, rental_id=?, " +
                     "amount=?, payment_date=? WHERE payment_id=?";
        return ejecutarActualizacion(sql,
            payment.getCustomerId(), payment.getStaffId(), payment.getRentalId(),
            payment.getAmount(), payment.getPaymentDate(), payment.getPaymentId());
    }

    /**
     * Elimina un pago por su ID.
     * @param id ID del pago
     * @return true si fue exitoso
     */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM payment WHERE payment_id=?";
        return ejecutarActualizacion(sql, id);
    }

    /**
     * Obtiene un pago por su ID.
     * @param id ID del pago
     * @return Payment encontrado o null
     */
    @Override
    public Payment get(int id) {
        String sql = "SELECT * FROM payment WHERE payment_id=?";
        ResultSet rs = ejecutarConsulta(sql, id);
        try {
            if (rs != null && rs.next()) {
                return new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("staff_id"),
                    rs.getInt("rental_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_date"),
                    rs.getString("last_update")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    /**
     * Obtiene todos los pagos.
     * @return Lista de pagos
     */
    @Override
    public List<Payment> getAll() {
        String sql = "SELECT * FROM payment";
        ResultSet rs = ejecutarConsulta(sql);
        List<Payment> lista = new ArrayList<>();
        try {
            while (rs != null && rs.next()) {
                lista.add(new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("customer_id"),
                    rs.getInt("staff_id"),
                    rs.getInt("rental_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_date"),
                    rs.getString("last_update")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }
}