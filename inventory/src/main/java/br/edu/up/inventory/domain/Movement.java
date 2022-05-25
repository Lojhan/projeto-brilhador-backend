package br.edu.up.inventory.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Movement {

    @Id
    @GeneratedValue
    private long id;
    private double totalPrice;
    private Timestamp dateTime;
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private int nature;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    public Movement() {

    }

    public Movement(String name, int totalPrice, Timestamp dateTime, int nature, long id, Product product) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
        this.nature = nature;
        this.id = id;
        this.product = product;
    }

    public void updateMovement(Movement movementChanged) {
        this.name = movementChanged.getName();
        this.nature = movementChanged.getNature();
        this.dateTime = movementChanged.getDateTime();
        this.totalPrice = movementChanged.getTotalPrice();
        this.product = movementChanged.getProduct();
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

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
