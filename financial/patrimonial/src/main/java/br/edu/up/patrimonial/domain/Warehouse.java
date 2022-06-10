package br.edu.up.patrimonial.domain;

public class Warehouse {

    private long id;
    private String description;
    private boolean isFull;

    public Warehouse() {

    }

    public Warehouse(long id, String description, boolean isFull) {
        this.id = id;
        this.description = description;
        this.isFull = isFull;
    }

    public void updateWarehouse(Warehouse warehouseChanged) {
        this.description = warehouseChanged.getDescription();
        this.isFull = warehouseChanged.getIsFull();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }
}
