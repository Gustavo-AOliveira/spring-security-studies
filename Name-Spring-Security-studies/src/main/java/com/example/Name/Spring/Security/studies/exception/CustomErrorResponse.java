package com.example.Name.Spring.Security.studies.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
public class CustomErrorResponse {

    private HttpStatus httpStatus;

    private String message;

}
