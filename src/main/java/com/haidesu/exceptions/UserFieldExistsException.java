package com.haidesu.exceptions;

public class UserFieldExistsException extends RuntimeException {
    public UserFieldExistsException(String message) {
        super(message);
    }
}
