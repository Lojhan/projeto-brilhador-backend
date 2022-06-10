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
    private int quantity;

    @Enumerated(EnumType.ORDINAL)
    private MovementNature nature;

    @Column(name = "id_product")
    private long idProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_product", updatable = false, insertable = false)
    private Product product;

    public Movement() {

    }

    public Movement(String name, int totalPrice, Timestamp dateTime, MovementNature nature, long id, long idProduct) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
        this.nature = nature;
        this.id = id;
        this.idProduct = idProduct;
    }

    public Movement(String name, int totalPrice, Timestamp dateTime, MovementNature nature, long idProduct) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
        this.nature = nature;
        this.idProduct = idProduct;
    }

    public void updateMovement(Movement movementChanged) {
        this.name = movementChanged.getName();
        this.nature = movementChanged.getNature();
        this.dateTime = movementChanged.getDateTime();
        this.totalPrice = movementChanged.getTotalPrice();
        this.idProduct = movementChanged.getIdProduct();
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

    public MovementNature getNature() {
        return nature;
    }

    public void setNature(MovementNature nature) {
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

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
