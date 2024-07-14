package com.pizzamanagement.pizzaorder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class PizzaOrderException {
    public ResponseEntity<?>resourceNotFoundException(ResourceNotFound ex, WebRequest request){
        ErroDetails erroDetails=new ErroDetails(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(erroDetails, HttpStatus.NOT_FOUND);
    }
}
