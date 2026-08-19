package com.example.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ResultAspect {

    @Pointcut("execution (* com.example.bank.service.*.*.(..))")
    public void accountOperations() {}

    @AfterReturning(pointcut = "accountOperations()", returning = "result")
    public void successfulOperation(JoinPoint joinPoint, Object result) {
        System.out.println("[RESULT] " + joinPoint.getSignature().getName() + " returned : " + result);
    }

    @AfterThrowing(pointcut = "accountOperations()", throwing = "exception")
    public void failedOperation(JoinPoint joinPoint, Throwable exception) {
        System.out.println("[RESULT] " + joinPoint.getSignature().getName() + " failed : " + exception.getMessage());
    }

}
