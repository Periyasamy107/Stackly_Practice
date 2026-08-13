package com.demo.listValuesAnnotationPrac;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer3 {

    @Value("Viam")
    private String customerName;

    @Value("SAM435019")
    private String customerNumber;

    @Value("#{bank.accountTypes[2]}")
    private String accountType;

    @Value("#{bank.bankName}")
    private String bankName;

    @Value("#{bank.location}")
    private String bankLocation;

    @PostConstruct
    public void display() {
        System.out.println();
        System.out.println("Customer3 Name : " + customerName);
        System.out.println("Customer3 Number : " + customerNumber);
        System.out.println("Bank Name : " + bankName);
        System.out.println("Account Type : " + accountType);
        System.out.println("Bank Location : " + bankLocation);
        System.out.println();
    }

}
