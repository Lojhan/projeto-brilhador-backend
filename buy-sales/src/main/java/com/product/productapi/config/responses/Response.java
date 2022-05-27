package com.product.productapi.config.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Integer status;
    private String message;

    public static Response successResponse(String message) {
        return Response
                .builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .build();
    }
}


