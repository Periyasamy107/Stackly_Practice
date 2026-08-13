package com.demo.listValuesAnnotationPrac;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer4 {

    @Value("Teema")
    private String customerName;

    @Value("SAM888750")
    private String customerNumber;

    @Value("#{bank.accountTypes[3]}")
    private String accountType;

    @Value("#{bank.bankName}")
    private String bankName;

    @Value("#{bank.location}")
    private String bankLocation;

    @PostConstruct
    public void display() {
        System.out.println();
        System.out.println("Customer4 Name : " + customerName);
        System.out.println("Customer4 Number : " + customerNumber);
        System.out.println("Bank Name : " + bankName);
        System.out.println("Account Type : " + accountType);
        System.out.println("Bank Location : " + bankLocation);
        System.out.println();
    }

}
