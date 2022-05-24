package br.edu.up.inventory.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Movement {

    @Id
    @GeneratedValue
    private long id;

    private int totalPrice;

    private Timestamp dateTime;
    private String name;

    private int nature;

    public Movement() {

    }

    public Movement(String name, int totalPrice, Timestamp dateTime, int nature, long id ) {
        this.name = name;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
        this.nature = nature;
        this.id = id;
    }

    public int getTotalPrice() { return totalPrice;}

    public void setTotalPrice(int totalPrice) {this.totalPrice = totalPrice;}
    public void updateMovement(Movement movementChanged) {
        this.name = movementChanged.getName();
        this.nature= movementChanged.getNature();
        this.dateTime= movementChanged.getDateTime();
        this.totalPrice= movementChanged.getTotalPrice();
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

    public int getNature() {return nature; }

    public void setNature(int nature) {this.nature = nature;}

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }
}
