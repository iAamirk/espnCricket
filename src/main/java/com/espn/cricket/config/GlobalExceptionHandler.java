package com.espn.cricket.config;

import com.espn.cricket.exception.PlayerNotFoundException;
import com.espn.cricket.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePlayerNotFoundException(PlayerNotFoundException ex) {
        return new ErrorResponse("404", ex.getMessage());
    }
}
