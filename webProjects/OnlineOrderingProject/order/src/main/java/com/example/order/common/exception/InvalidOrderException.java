package com.example.order.common.exception;

public class InvalidOrderException extends BusinessException {

    public InvalidOrderException(String message) {
        super("INVALID_ORDER", message);
    }

}
