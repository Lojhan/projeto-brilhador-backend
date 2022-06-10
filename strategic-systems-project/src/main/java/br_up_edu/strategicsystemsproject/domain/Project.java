package br_up_edu.strategicsystemsproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import br_up_edu.strategicsystemsproject.repository.ProjectRepository;

@Entity
public class Project {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double daysToDelivery;
    private Long id_area;

    public Project() {

    }

    public Project(String name, String descripction, Double daysToDelivery) {
        this.name = name;
        this.description = descripction;
        this.daysToDelivery = daysToDelivery;
    }
    public Long getId_area() {
        return id_area;
    }

    public void setId_area(Long id_area) {
        this.id_area = id_area;
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

}
