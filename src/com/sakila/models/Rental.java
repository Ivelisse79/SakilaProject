/**
 * Modelo que representa la tabla rental de Sakila.
 * @author IvelisseCalzado
 * @version 1.0
 */
package com.sakila.models;

public class Rental {

    private int rentalId;
    private String rentalDate;
    private int inventoryId;
    private int customerId;
    private String returnDate;
    private int staffId;
    private String lastUpdate;

    /** Constructor vacío */
    public Rental() {}

    /** Constructor con parámetros */
    public Rental(int rentalId, String rentalDate, int inventoryId,
                  int customerId, String returnDate, int staffId, String lastUpdate) {
        this.rentalId = rentalId;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.customerId = customerId;
        this.returnDate = returnDate;
        this.staffId = staffId;
        this.lastUpdate = lastUpdate;
    }

    // Getters y Setters
    public int getRentalId() { return rentalId; }
    public void setRentalId(int rentalId) { this.rentalId = rentalId; }

    public String getRentalDate() { return rentalDate; }
    public void setRentalDate(String rentalDate) { this.rentalDate = rentalDate; }

    public int getInventoryId() { return inventoryId; }
    public void setInventoryId(int inventoryId) { this.inventoryId = inventoryId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }

    public int getStaffId() { return staffId; }
    public void setStaffId(int staffId) { this.staffId = staffId; }

    public String getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(String lastUpdate) { this.lastUpdate = lastUpdate; }

    /** @return String con los datos de la renta */
    @Override
    public String toString() {
        return "Rental [ID=" + rentalId + ", Cliente=" + customerId +
               ", Inventario=" + inventoryId + ", Fecha=" + rentalDate + "]";
    }
}