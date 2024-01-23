package com.example.Name.Spring.Security.studies.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class Exception {

    @ExceptionHandler(EmptyListException.class)

    public ResponseEntity<CustomErrorResponse> emptyListException(EmptyListException exception){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.OK, exception.getMessage());
        return ResponseEntity.status(HttpStatus.OK).body(customErrorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException ex){
        var fieldError = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldError.stream().map(ValidationErrorsDTO::new).toList());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomErrorResponse> HttpMessageNotReadableException(){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST,"Fill in the fields correctely");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorResponse);
    }
    @ExceptionHandler(LoginAlreadyExists.class)
    public ResponseEntity<CustomErrorResponse> loginAlreadyExistsException(LoginAlreadyExists exception){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorResponse);
    }
    @ExceptionHandler(loginIncorrectException.class)
    public ResponseEntity<CustomErrorResponse> loginIncorrectException(loginIncorrectException exception){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorResponse);

    }

}









