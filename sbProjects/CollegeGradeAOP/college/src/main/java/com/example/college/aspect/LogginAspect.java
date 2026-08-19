package com.example.college.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(1)
public class LogginAspect {

    @Pointcut("execution (* com.example.college.service.*.*(..))")
    public void serviceMethods() {}

    @Before("serviceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("AOP @Before");
        System.out.println("--------------------------------------");
        System.out.println("Method started : " + joinPoint.getSignature().getName());
        System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("serviceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("AOP @After");
        System.out.println("--------------------------------------");
        System.out.println("Method completed : " + joinPoint.getSignature().getName());
        System.out.println();
    }

    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("AOP @AfterReturning");
        System.out.println("--------------------------------------");
        System.out.println("Method  : " + joinPoint.getSignature().getName());
        System.out.println("Returned Result : " + result);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "exception")
    public void logAfterReturning(JoinPoint joinPoint, Exception exception) {
        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("AOP @AfterThrowing");
        System.out.println("--------------------------------------");
        System.out.println("Method  : " + joinPoint.getSignature().getName());
        System.out.println("Exception : " + exception);
    }


}
