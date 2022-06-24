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
    
    public Task() {
        
    }

    public Task(String name, Project project, String descripction, Double daysToFinish, String status) {
        this.name = name;
        this.description = descripction;
        this.daysToFinish = daysToFinish;
        this.status = status;
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
