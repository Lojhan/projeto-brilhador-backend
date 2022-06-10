package com.supplyChain.supplyChainProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supplyChain.supplyChainProject.models.enums.EStatus;
import com.supplyChain.supplyChainProject.models.interfaces.IValidation;

import javax.persistence.*;

@Entity
public class EmployeeTask extends Validation {

    public EmployeeTask() {}

    public EmployeeTask(Long id, String name, String description, double daysToFinish, EStatus Status) {
        super();
        Id = id;
        this.name = name;
        this.description = description;
        this.daysToFinish = daysToFinish;
        this.Status = Status;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    private String name;
    private String description;
    private double daysToFinish;
    private EStatus Status;

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

    public EStatus getStatus() {
        return Status;
    }

    public void setStatus(EStatus EStatus) {
        this.Status = EStatus;
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

        if(getStatus() == EStatus.NONE) {
            setValid(false);
        }
    }

    @Override
    public String toString() {
        return " Task: " + this.name + " Description: " + this.description + " IsValid: " + this.isValid() + "Status: " + this.Status;
    }
}
