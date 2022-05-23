package com.product.productapi.config.exceptions;

import lombok.Data;

@Data
public class ExceptionBody {

    private int status;
    private String message;

}
