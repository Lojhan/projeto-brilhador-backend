package com.mail.sender.models.exceptions;

public class NotFound extends Exception {
    
    public NotFound(String entity) {
        super(String.format("%s not found", entity));
    }
}
