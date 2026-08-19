package com.example.payroll.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class PayrollLoggingAspect {

    @Pointcut("execution (* com.example.payroll.service.PayrollService.*(..))")
    public void payrollMethods() {}

    @Before("payrollMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] Started: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "payrollMethods()", returning = "result")
    public void logResult(JoinPoint joinPoint, Object result) {
        System.out.println("[LOG] Completed: " + joinPoint.getSignature().getName() + " | Result: " + result);
    }

    @AfterThrowing(pointcut = "payrollMethods()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("[ERROR] " + joinPoint.getSignature().getName() + " | " + exception.getMessage());
    }

}
