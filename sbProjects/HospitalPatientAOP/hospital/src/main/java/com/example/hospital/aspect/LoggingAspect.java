package com.example.hospital.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LoggingAspect {

    @Pointcut("execution (* com.example.hospital.service.*.*(..))")
    public void hospitalMethods() {}

    @Before("hospitalMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] Started: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "hospitalMethods()", returning = "result")
    public void logResult(JoinPoint joinPoint, Object result) {
        System.out.println("[LOG] Completed: " + joinPoint.getSignature().getName() + " | Result: " + result);
    }

    @AfterThrowing(pointcut = "hospitalMethods()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("[ERROR] " + joinPoint.getSignature().getName() + " | " + exception.getMessage());
    }

}
