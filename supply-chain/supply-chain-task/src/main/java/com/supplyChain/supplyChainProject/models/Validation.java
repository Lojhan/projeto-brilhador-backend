package com.supplyChain.supplyChainProject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.supplyChain.supplyChainProject.models.interfaces.IValidation;

import javax.persistence.Transient;

public abstract class Validation implements IValidation {

    public Validation() {
        IsValid = true;
    }
    @Transient @JsonIgnore
    public boolean IsValid;

    public boolean isValid() {
        return IsValid;
    }

    public void setValid(boolean valid) {
        IsValid = valid;
    }

}
