package com.supplyChain.supplyChainProject.models;

import com.supplyChain.supplyChainProject.models.enums.Status;
import com.supplyChain.supplyChainProject.models.interfaces.IValidation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class EmployeeTask extends Validation implements IValidation {

    public EmployeeTask() {}

    public EmployeeTask(Long id, String name, String description, double daysToFinish, Status status) {
        super();
        Id = id;
        this.name = name;
        this.description = description;
        this.daysToFinish = daysToFinish;
        this.status = status;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    private String name;
    private String description;
    private double daysToFinish;
    private Status status;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public double getDaysToFinish() {
        return daysToFinish;
    }

    public void setDaysToFinish(double daysToFinish) {
        this.daysToFinish = daysToFinish;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void Validate() {
        if(getName() == null || getName() == "") {
            setValid(false);
        }

        if(getDescription() == null || getDescription() == "") {
            setValid(false);
        }

        if(getDaysToFinish() < -1) {
            setValid(false);
        }

        if(getStatus() == Status.NONE) {
            setValid(false);
        }
    }

    @Override
    public String toString() {
        return " Task: " + this.name + " Description: " + this.description + " IsValid: " + this.isValid() + "Status: " + this.status;
    }
}
