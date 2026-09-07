package com.example.order.common.exception;

public class PaymentFailedException extends BusinessException {

    public PaymentFailedException(String message) {
        super("PAYMENT_FAILED", message);
    }

}