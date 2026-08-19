package com.example.demoAOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PaymentAudit {

    @Before("execution( * com.example.demoAOP.service.PaymentService.makePayment(..))")
    public void logBeforePayment(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("AUDIT: User " + args[0] + " is trying to make the payment of Rs." + args[1]);
    }

    @AfterReturning(
            pointcut = "execution(* com.example.demoAOP.service.PaymentService.makePayment(..))",
            returning = "balance"
    )
    public void logPaymentSuccess(JoinPoint joinPoint, double balance) {
        Object[] args = joinPoint.getArgs();
        System.out.println("AUDIT: Payment successful for the User " + args[0] + " and the balance is : Rs." + balance);
    }

    @AfterThrowing(pointcut = "execution(* com.example.demoAOP.service.PaymentService.makePayment(..))", throwing = "ex")
    public void logPaymentFailure(JoinPoint joinPoint, Exception ex) {
        Object[] args = joinPoint.getArgs();
        System.out.println("AUDIT: Payment failed for the User " + args[0] + " Reason : " + ex.getMessage());
    }




}
