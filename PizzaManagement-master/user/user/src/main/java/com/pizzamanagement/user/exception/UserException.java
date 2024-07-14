package com.pizzamanagement.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class UserException {
    public ResponseEntity<?>responseNotFoundException(ResourceNotFound ex, WebRequest request){
        ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
