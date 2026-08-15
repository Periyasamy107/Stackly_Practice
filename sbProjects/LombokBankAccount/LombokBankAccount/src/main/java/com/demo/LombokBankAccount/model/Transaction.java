package com.demo.LombokBankAccount.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private String transactionId;
    private BankAccount bankAccount;
    private Customer customer;
    private String transactionType;
    private double amount;
}
