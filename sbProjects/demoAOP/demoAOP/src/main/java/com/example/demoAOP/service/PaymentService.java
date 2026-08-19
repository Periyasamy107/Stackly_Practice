package com.example.demoAOP.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public double makePayment(String userName, double amount, double balace) {
        if(amount<=0){
            throw new RuntimeException("Invalid payment amount");
        }

        double remainingBalance = balace - amount;
        System.out.println("Payment of Rs." + amount + " made by " + userName);
        return  remainingBalance;
    }
}
