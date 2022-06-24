package com.supplyChain.supplyChainProject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class EmployeeTask {

    public EmployeeTask() {}

    public EmployeeTask(Long id, String task, String description, String dependOnThirdParty, boolean status) {
        Id = id;
        this.task = task;
        this.description = description;
        this.dependOnThirdParty = dependOnThirdParty;
        this.status = status;
        this.ourId = "@gestaodecadeiasup";
    }

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long Id;
    private String task;
    private String description;
    private String dependOnThirdParty;
    private String ourId;
    private boolean status;

    public String getOurId() {
        return ourId;
    }

    public void setOurId(String ourId) {
        this.ourId = ourId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
