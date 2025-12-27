package com.example.securityauthenticationauthorization2025.exceptions;

public class UserExistException extends RuntimeException {
    public UserExistException() {
    }

    public UserExistException(String message) {
        super(message);
    }
}
