package br_up_edu.strategicsystemsproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
    
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Double daysToFinish;
    private String status;
    private Long id_area;
    private Long id_project;
    
    public Task() {
        
    }
    
    public Task(String name, Project project, String descripction, Double daysToFinish, String status, Long id_area, Long id_project) {
        this.name = name;
        this.description = descripction;
        this.daysToFinish = daysToFinish;
        this.status = status;
        this.id_area = id_area;
        this.id_project = id_project;
    }

    public Long getId_project() {
        return id_project;
    }

    public void setId_project(Long id_project) {
        this.id_project = id_project;
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

    public Double getDaysToFinish() {
        return this.daysToFinish;
    }

    public void setDaysToFinish(Double daysToFinish) {
        this.daysToFinish = daysToFinish;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
