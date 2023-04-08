package com.haidesu.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(long id) {
        super("User id not found : [" + id + "]");
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
