package br.edu.up.inventory.domain;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
    private long id;
    private int quantity;


    @Column(name = "id_product")
    private long idProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_product", updatable = false, insertable = false)
    private Product product;

    @Column(name = "id_process")
    private long idProcess;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_process", updatable = false, insertable = false)
    private Process process;

    public Ingredient() {

    }

    public Ingredient(long id, int quantity, long idProduct, long idProcess) {
        this.id = id;
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idProcess = idProcess;
    }

    public void updateIngredient(Ingredient updatedIngredient) {
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

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public long getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(long idProcess) {
        this.idProcess = idProcess;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }
}
