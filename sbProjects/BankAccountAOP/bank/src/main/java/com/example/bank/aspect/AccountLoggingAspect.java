package com.example.bank.aspect;

import com.example.bank.model.BankAccount;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class AccountLoggingAspect {

    @Pointcut("execution (* com.example.bank.service.*.*(..))")
    public void accountServiceMethods() {}

    @Before("accountServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[LOG] Started : " + joinPoint.getSignature().getName());
    }

    @After("accountServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[LOG] Finished : " + joinPoint.getSignature().getName());
    }

}
