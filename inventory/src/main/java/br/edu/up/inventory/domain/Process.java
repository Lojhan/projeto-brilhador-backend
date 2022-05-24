package br.edu.up.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Process {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String description;

    private Number quantityProduced;
    public Process() {

    }

    public Process(String name, String description, String ingredient, Number quantityProduced) {
        this.name = name;
        this.description = description;
        this.quantityProduced = quantityProduced;
    }

    public void updateProcess(Process updatedProcess) {
        this.name = updatedProcess.getName();
        this.description = updatedProcess.getDescription();
        this.quantityProduced = updatedProcess.getQuantityProduced();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Number getQuantityProduced() {
        return quantityProduced;
    }

    public void setQuantityProduced(Number quantity_produced) {
        this.quantityProduced = quantityProduced;
    }
}
