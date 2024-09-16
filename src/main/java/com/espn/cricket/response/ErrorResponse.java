package com.espn.cricket.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String statusCode;
    private String errorMessage;
}
