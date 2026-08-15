package com.demo.listValuesAnnotationPrac;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Bank {

    @Value("Sam Bank")
    private String bankName;

    @Value("#{{'Current Account', 'Savings Account', 'Fixed Deposit', " +
            "'Recurring Deposit', 'NRI Account', 'Demat Account'}}")
    private List<String> accountTypes;

    @Value("Chennai")
    private String location;

    public String getBankName() {
        return bankName;
    }

    public List<String> getAccountTypes() {
        return accountTypes;
    }

    public String getLocation() {
        return location;
    }
}
