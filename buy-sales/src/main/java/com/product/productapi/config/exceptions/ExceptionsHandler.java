package com.product.productapi.config.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(ValidationException validationException) {
        var exceptionBody = new ExceptionBody();
        exceptionBody.setStatus(HttpStatus.BAD_REQUEST.value());
        exceptionBody.setMessage(validationException.getMessage());

        return new ResponseEntity<>(exceptionBody, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException authenticationException) {
        var exceptionBody = new ExceptionBody();
        exceptionBody.setStatus(HttpStatus.UNAUTHORIZED.value());
        exceptionBody.setMessage(authenticationException.getMessage());

        return new ResponseEntity<>(exceptionBody, HttpStatus.UNAUTHORIZED);
    }

}
