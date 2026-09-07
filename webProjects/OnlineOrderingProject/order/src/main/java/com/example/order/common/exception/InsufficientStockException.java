package com.example.order.common.exception;

public class InsufficientStockException extends BusinessException {

    public InsufficientStockException(String message) {
        super("INSUFFICIENT_STOCK", message);
    }

}