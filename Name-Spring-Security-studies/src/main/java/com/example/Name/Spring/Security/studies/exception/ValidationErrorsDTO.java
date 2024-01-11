package com.example.Name.Spring.Security.studies.exception;

import org.springframework.validation.FieldError;

public record ValidationErrorsDTO(String field, String msg) {

    public ValidationErrorsDTO(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
