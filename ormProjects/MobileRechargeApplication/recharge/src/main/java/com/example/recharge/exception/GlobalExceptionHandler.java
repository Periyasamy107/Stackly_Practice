package com.example.recharge.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return errors;
    }

    @ExceptionHandler(DuplicateRechargeException.class)
    public ResponseEntity<ErrorMessage> handleDuplicateRecharge(DuplicateRechargeException exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(
                LocalDateTime.now(), exception.getMessage(), request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
    }

    @ExceptionHandler(RechargeNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(RechargeNotFoundException exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

}
