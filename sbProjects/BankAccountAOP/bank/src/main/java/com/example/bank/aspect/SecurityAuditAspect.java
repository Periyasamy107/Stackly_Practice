package com.example.bank.aspect;

import com.example.bank.annotation.SensitiveOperation;
import com.example.bank.model.BankAccount;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class SecurityAuditAspect {

    @Before("execution (* com.example.bank.service.*.*(..)) && @annotation(sensitiveOperation) && args(account, amount)")
    public void auditSensitiveOperation(JoinPoint joinPoint, SensitiveOperation sensitiveOperation, BankAccount account, double amount) {
        System.out.println("[AUDIT] Sensitive Operation : " + joinPoint.getSignature().getName());
        System.out.println("[AUDIT] Account : " + account.getAccountNumber());
        System.out.println("[AUDIT] Amount : " + amount);
    }

    @After("execution (* com.example.bank.service.*.*(..)) && @annotation(sensitiveOperation)")
    public void auditCompletedOperation(JoinPoint joinPoint, SensitiveOperation sensitiveOperation) {
        System.out.println("[AUDIT] Sensitive Operation Completed : " + joinPoint.getSignature().getName());
    }

}
