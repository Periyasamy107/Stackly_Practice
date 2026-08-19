package com.example.bankAOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Around("execution(* com.example.bankAOP.BankService.*(..))")
    public Object logBankingOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();

        System.out.println();
        System.out.println("=============================");
        System.out.println("Bank Operation Started");
        System.out.println("Method : " + methodName);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("Bank Operation Completed.");
        System.out.println("Execution time " + (endTime - startTime) + " ms");
        System.out.println("=============================");

        return result;

    }

}
