package com.supplyChain.supplyChainProject.models;

public class Validation {

    public Validation() {
        IsValid = true;
    }
    public boolean IsValid;

    public boolean isValid() {
        return IsValid;
    }

    public void setValid(boolean valid) {
        IsValid = valid;
    }
}