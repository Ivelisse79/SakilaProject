/**
 * Modelo que representa la tabla payment de Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.models;

public class Payment {

    private int paymentId;
    private int customerId;
    private int staffId;
    private int rentalId;
    private double amount;
    private String paymentDate;
    private String lastUpdate;

    /** Constructor vacío */
    public Payment() {}

    /** Constructor con parámetros */
    public Payment(int paymentId, int customerId, int staffId, int rentalId,
                   double amount, String paymentDate, String lastUpdate) {
        this.paymentId = paymentId;
        this.customerId = customerId;
        this.staffId = staffId;
        this.rentalId = rentalId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
    }

    // Getters y Setters
    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public int getRentalId() { return rentalId; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentDate() { return paymentDate; }
    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    /** @return String con los datos del pago */
    @Override
    public String toString() {
        return "Payment [ID=" + paymentId + ", Cliente=" + customerId +
               ", Monto=" + amount + ", Fecha=" + paymentDate + "]";
    }
}