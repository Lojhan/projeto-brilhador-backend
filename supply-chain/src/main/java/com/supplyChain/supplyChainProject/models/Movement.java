package com.supplyChain.supplyChainProject.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movement {
    @Id
    @GeneratedValue
    private String id;

    private String type;
    private Integer quantity;
    private Integer current_stock_quantity;
    private Date created_at;
    
    public Movement(String id, String type, Integer quantity, Integer current_stock_quantity, Date created_at) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
        this.current_stock_quantity = current_stock_quantity;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getCurrent_stock_quantity() {
        return current_stock_quantity;
    }
    public void setCurrent_stock_quantity(Integer current_stock_quantity) {
        this.current_stock_quantity = current_stock_quantity;
    }
    public Date getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
}
