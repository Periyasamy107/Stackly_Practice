package com.example.order.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    @Pointcut("execution (* com.example.order.service.*.*(..))")
    public void customerOrderMethods() {}

    @Before("customerOrderMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] Started: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "customerOrderMethods()", returning = "result")
    public void logSuccessful(JoinPoint joinPoint) {
        System.out.println("[LOG] Completed: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "customerOrderMethods()", throwing = "exception")
    public void logFailure(JoinPoint joinPoint, Exception exception) {
        System.out.println("[ERROR] " + joinPoint.getSignature().getName() + " : " + exception.getMessage());
    }

}
