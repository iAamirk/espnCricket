package com.espn.cricket.exception;

import lombok.Getter;

@Getter
public class PlayerNotFoundException extends RuntimeException {

    private final String message;

    public PlayerNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
