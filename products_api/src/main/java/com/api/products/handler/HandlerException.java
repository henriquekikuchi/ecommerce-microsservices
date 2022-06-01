package com.api.products.handler;

import com.api.products.exception.ExceptionDetails;
import com.api.products.exception.ProductInsufficientStockException;
import com.api.products.exception.ProductInvalidAmountException;
import com.api.products.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerProductNotFoundExeception(ProductNotFoundException productNotFoundExeception) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not found Exception, Product not found!")
                .details(productNotFoundExeception.getMessage())
                .developerMessage(productNotFoundExeception.getClass().getName())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductInvalidAmountException.class)
    public ResponseEntity<ExceptionDetails> handlerProductInvalidAmountException(ProductInvalidAmountException productInvalidAmountException) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("ProductInvalidAmountException!")
                .details(productInvalidAmountException.getMessage())
                .developerMessage(productInvalidAmountException.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductInsufficientStockException.class)
    public ResponseEntity<ExceptionDetails> handlerProductInsufficientStockException(ProductInsufficientStockException productInsufficientStockException) {
        return new ResponseEntity<>(ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("ProductInsufficientStockException")
                .details(productInsufficientStockException.getMessage())
                .developerMessage(productInsufficientStockException.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
