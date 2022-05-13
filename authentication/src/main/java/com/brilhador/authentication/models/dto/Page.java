package com.brilhador.authentication.models.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Page {

    @Min(value = 1, message = "Paging must start with page 1")
    private long number = 1;
    @Min(value = 1, message = "You can request minimum 1 records")
    @Max(value = 100, message = "You can request maximum 100 records")
    private long limit = 10;


    public Page() {}
    public Page(
        @Min(value = 1, message = "Paging must start with page 1") long number,
        @Min(value = 1, message = "You can request minimum 1 records") 
        @Max(value = 100, message = "You can request maximum 100 records") long limit
    ) {
        this.number = number;
        this.limit = limit;
    }

    

}