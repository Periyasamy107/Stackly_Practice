package com.example.college.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class PerformanceAspect {

    @Around("execution (* com.example.college.service.*.*(..))")
    public Object mesureExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("**************************************");
        System.out.println("AOP @Around - Before Target Method");
        System.out.println("**************************************");
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println("**************************************");
        System.out.println("AOP @Around - Before Target Method");
        System.out.println("**************************************");
        System.out.println("Method : " + proceedingJoinPoint.getSignature().getName());
        System.out.println("Execution Time : " + (endTime - startTime) + " ms");
        return result;
    }

}
