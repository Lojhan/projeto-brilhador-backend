package com.clientRelationship.clientRelationshipProject.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "investments")
public class Investment {

    
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    Double investmentValue;

    String projectId;
    String userId;
    String projectName;
    String projectDescription;
    Double projectDaysToDelivery;

    public Investment() {
    }

    public Investment(String id, Double investmentValue, String projectId, String userId, String projectName, String projectDescription, Double projectDaysToDelivery) {
        this.id = id;
        this.investmentValue = investmentValue;
        this.projectId = projectId;
        this.userId = userId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectDaysToDelivery = projectDaysToDelivery;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getInvestmentValue() {
        return investmentValue;
    }

    public void setInvestmentValue(Double investmentValue) {
        this.investmentValue = investmentValue;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Double getProjectDaysToDelivery() {
        return projectDaysToDelivery;
    }

    public void setProjectDaysToDelivery(Double projectDaysToDelivery) {
        this.projectDaysToDelivery = projectDaysToDelivery;
    }
}
