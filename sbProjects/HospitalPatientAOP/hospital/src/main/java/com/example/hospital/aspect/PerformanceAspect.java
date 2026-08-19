package com.example.hospital.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(3)
public class PerformanceAspect {

    @Around("execution (* com.example.hospital.service.*.*(..))")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable {

        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();

        System.out.println("[PERFORMANCE] " +
                proceedingJoinPoint.getSignature().getName() +
                " took " +
                (endTime - startTime) +
                " ms."
        );

        return result;

    }

}
