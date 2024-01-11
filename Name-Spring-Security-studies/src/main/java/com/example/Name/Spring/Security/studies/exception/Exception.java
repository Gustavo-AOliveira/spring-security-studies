package com.example.Name.Spring.Security.studies.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exception {

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity emptyListException(){
        String msg = "Product list is empty";
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException ex){
    var fieldError = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldError.stream().map(ValidationErrorsDTO::new).toList());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity HttpMessageNotReadableException(){
        String msg = "Fill in the fields correctely";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
    }
}









