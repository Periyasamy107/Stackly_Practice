package com.demo.listValuesAnnotationPrac;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer1 {

    @Value("William")
    private String customerName;

    @Value("SAM104567")
    private String customerNumber;

    @Value("#{bank.accountTypes[0]}")
    private String accountType;

    @Value("#{bank.bankName}")
    private String bankName;

    @Value("#{bank.location}")
    private String bankLocation;

    @PostConstruct
    public void display() {
        System.out.println();
        System.out.println("Customer1 Name : " + customerName);
        System.out.println("Customer1 Number : " + customerNumber);
        System.out.println("Bank Name : " + bankName);
        System.out.println("Account Type : " + accountType);
        System.out.println("Bank Location : " + bankLocation);
        System.out.println();
    }

}
