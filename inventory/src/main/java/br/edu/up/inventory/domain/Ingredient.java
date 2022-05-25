package br.edu.up.inventory.domain;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Number quantity;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idProcess")
    private Process process;

    public Ingredient() {

    }

    public Ingredient(long id, String name, Number quantity, Product product, Process process) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.product = product;
        this.process = process;
    }

    public void updateIngredient(Ingredient updatedIngredient) {
        this.name = updatedIngredient.getName();
        this.quantity = updatedIngredient.getQuantity();
        this.product = updatedIngredient.getProduct();
        this.process = updatedIngredient.getProcess();
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

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
