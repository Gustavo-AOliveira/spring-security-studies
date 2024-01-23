package com.example.Name.Spring.Security.studies.exception;

public class EmptyListException extends RuntimeException{
    public EmptyListException() {
        super("The list is empty");
    }
    public EmptyListException(String message) {
        super(message);
    }
}
