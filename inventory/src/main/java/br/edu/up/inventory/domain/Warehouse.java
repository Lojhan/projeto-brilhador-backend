package br.edu.up.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue
    private long id;
    private String description;

    public Warehouse() {

    }

    public Warehouse(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public void updateWarehouse(Warehouse warehouseChanged) {
        this.description = warehouseChanged.getDescription();
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

}
