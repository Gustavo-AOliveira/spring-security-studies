package com.example.Name.Spring.Security.studies.exception;

public class loginIncorrectException extends RuntimeException{
    public loginIncorrectException() {
        super("Login or password are incorrect.");
    }
    public loginIncorrectException(String message) {
        super(message);
    }
}
