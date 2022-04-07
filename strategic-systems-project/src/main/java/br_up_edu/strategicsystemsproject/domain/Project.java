package br_up_edu.strategicsystemsproject.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Project {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double daysToDelivery;
    private Area area;
    

    public Project(String name, String descripction, Double daysToDelivery, Area area) {
        this.name = name;
        this.description = descripction;
        this.daysToDelivery = daysToDelivery;
        this.area = area;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDaysToDelivery() {
        return this.daysToDelivery;
    }

    public void setDaysToDelivery(Double daysToDelivery) {
        this.daysToDelivery = daysToDelivery;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


}
