package com.example.payroll.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class PayrollPerformanceAspect {

    @Around("execution (* com.example.payroll.service.PayrollService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(
                "[PERFORMANCE] "
                + joinPoint.getSignature().getName()
                + " took "
                + (endTime - startTime)
                + " ms"
        );
        return  result;
    }

}
