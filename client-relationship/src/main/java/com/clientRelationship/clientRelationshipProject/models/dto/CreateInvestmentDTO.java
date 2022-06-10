package com.clientRelationship.clientRelationshipProject.models.dto;

public class CreateInvestmentDTO {
    
    private String projectId;
    private Double investmentValue;
    
    public CreateInvestmentDTO() {
    }
    
    public CreateInvestmentDTO(String projectId, Double investmentValue) {
        this.projectId = projectId;
        this.investmentValue = investmentValue;
    }
    
    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public Double getInvestmentValue() {
        return investmentValue;
    }
    public void setInvestmentValue(Double investmentValue) {
        this.investmentValue = investmentValue;
    }
}
