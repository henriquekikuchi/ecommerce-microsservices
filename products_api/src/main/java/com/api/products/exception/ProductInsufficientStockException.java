package com.api.products.exception;

public class ProductInsufficientStockException extends RuntimeException {
    public ProductInsufficientStockException(String message) {
        super(message);
    }
}
