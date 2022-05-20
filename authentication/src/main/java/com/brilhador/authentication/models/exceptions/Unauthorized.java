package com.brilhador.authentication.models.exceptions;

public class Unauthorized extends Exception { 
    public Unauthorized(String message){
        super(message);
    }
}
