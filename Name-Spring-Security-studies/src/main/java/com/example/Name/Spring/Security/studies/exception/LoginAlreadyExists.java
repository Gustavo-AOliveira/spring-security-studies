package com.example.Name.Spring.Security.studies.exception;

public class LoginAlreadyExists extends RuntimeException {
    public LoginAlreadyExists() {
        super("Login already exists");
    }

    public LoginAlreadyExists(String message) {
        super(message);
    }
}
