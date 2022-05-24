package br.edu.up.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Number quantity;
    // TODO add relationship
    private Long idProduct;
    // TODO add relationship
    private Long idProcess;

    public Ingredient() {

    }

    public Ingredient(long id, String name, Number quantity, Long idProduct, Long idProcess) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idProcess = idProcess;
    }

    public void updateIngredient(Ingredient updatedIngredient) {
        this.name = updatedIngredient.getName();
        this.quantity = updatedIngredient.getQuantity();
        this.idProduct = updatedIngredient.getIdProduct();
        this.idProcess = updatedIngredient.getIdProcess();
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

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Long getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(Long IdProcess) {
        this.idProcess = IdProcess;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long IdProduct) {
        this.idProduct = IdProduct;
    }
}
