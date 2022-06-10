package com.clientRelationship.clientRelationshipProject.models.dto;

public class SaveClientAddressDTO {
    String zipCode;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public SaveClientAddressDTO(String zipCode) {
        this.zipCode = zipCode;
    }

    public SaveClientAddressDTO() {
    }
}
