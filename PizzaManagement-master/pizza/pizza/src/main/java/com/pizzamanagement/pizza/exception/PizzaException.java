package com.pizzamanagement.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class PizzaException {
    public ResponseEntity<?>resourceNotFoundException(ResourceNotFound ex,WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }
}
