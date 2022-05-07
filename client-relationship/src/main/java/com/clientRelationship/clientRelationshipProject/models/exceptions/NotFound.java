package com.clientRelationship.clientRelationshipProject.models.exceptions;

public class NotFound extends Exception {
    
    public NotFound(String entity) {
        super(String.format("%s not found", entity));
    }
}
