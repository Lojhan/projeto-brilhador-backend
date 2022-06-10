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

    public EmployeeTask(Long id, String task, String description, String dependOnThirdParty, Status status) {
        super();
        Id = id;
        this.task = task;
        this.description = description;
        this.dependOnThirdParty = dependOnThirdParty;
        this.status = status;
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    private String task;
    private String description;
    private String dependOnThirdParty;
    private String ourId = "@gestaocadeiasup";
    private Status status;

    public String getOurId() {
        return ourId;
    }

    public void setOurId(String ourId) {
        this.ourId = "@gestaodecadeiasup";
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDependOnThirdParty() {
        return dependOnThirdParty;
    }

    public void setDependOnThirdParty(String dependOnThirdParty) {
        this.dependOnThirdParty = dependOnThirdParty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void Validate() {
        if(getTask() == null || getTask() == "") {
            setValid(false);
        }

        if(getDescription() == null || getDescription() == "") {
            setValid(false);
        }

        if(getStatus() == Status.NONE) {
            setValid(false);
        }
    }

    @Override
    public String toString() {
        return " Task: " + this.task + " Description: " + this.description + " IsValid: " + this.isValid() + "Status: " + this.status;
    }
}
