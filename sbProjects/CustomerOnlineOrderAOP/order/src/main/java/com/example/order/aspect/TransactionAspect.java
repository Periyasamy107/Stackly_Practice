package com.example.order.aspect;

import com.example.order.annotation.TransactionalOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.swing.plaf.PanelUI;

@Aspect
@Component
@Order(1)
public class TransactionAspect {

    @Around("execution (* com.example.order.service.*.*(..)) && @annotation(operation)")
    public Object manageTransaction(ProceedingJoinPoint joinPoint, TransactionalOperation operation) throws Throwable {

        System.out.println("[TRANSACTION] BEGIN");
        try{
            Object result = joinPoint.proceed();
            System.out.println("[TRANSACTION] COMMIT");
            return result;
        } catch (Throwable exception) {
            System.out.println("[TRANSACTION] ROLLBACK");
            throw exception;
        } finally {
            System.out.println("[TRANSACTION] CLEAN_UP");
        }


    }

}
