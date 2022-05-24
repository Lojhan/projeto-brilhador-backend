package br.edu.up.inventory.domain;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private double price;
    private String description;
    private String name;
    private int quantity;
    private String sku;


    @Column(name = "id_setor")
    private long idSetor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_setor", updatable = false, insertable = false)
    private Setor setor;

    public Product() {

    }

    public Product(long id, double price, String description, String name, int quantity, String sku){
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.sku = sku;
    }

    public void updateProduct(Product product) {
        this.price = product.getPrice();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.description = product.getDescription();
        this.sku = product.getSku();

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public long getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(long idSetor) {
        this.idSetor = idSetor;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
