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

    @Column(name = "id_warehouse")
    private long idWarehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_warehouse", updatable = false, insertable = false)
    private Warehouse warehouse;

    public Product() {

    }

    public Product(long id, double price, String description, String name, int quantity, String sku, long idWarehouse){
        this.id = id;
        this.price = price;
        this.description = description;
        this.name = name;
        this.quantity = quantity;
        this.sku = sku;
        this.idWarehouse = idWarehouse;
    }

    public void updateProduct(Product product) {
        this.price = product.getPrice();
        this.name = product.getName();
        this.description = product.getDescription();
        this.sku = product.getSku();
        this.idWarehouse = product.getIdWarehouse();
        // quantity should only be modified when creating a Movement
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


    public long getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(long idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
