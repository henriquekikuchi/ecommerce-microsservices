package com.api.products.exception;

public class ProductInvalidAmountException extends  RuntimeException {
    public ProductInvalidAmountException(String message) {
        super(message);
    }
}
