package com.clientRelationship.clientRelationshipProject.models;


public class ProjectInfo {
    private Long id;
    private String name;
    private String description;
    private Double daysToDelivery;

    public ProjectInfo() {
    }

    public ProjectInfo(Long id, String name, String description, Double daysToDelivery) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.daysToDelivery = daysToDelivery;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getDaysToDelivery() {
        return daysToDelivery;
    }
    public void setDaysToDelivery(Double daysToDelivery) {
        this.daysToDelivery = daysToDelivery;
    }
}
