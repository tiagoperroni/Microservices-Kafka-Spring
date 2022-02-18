package com.tiagoperroni.client.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerMain {
    
    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<MessageError> productOut(ProductOutOfStockException exception) {
        var error = new MessageError(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
