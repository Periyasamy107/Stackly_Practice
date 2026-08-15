package com.demo.LombokBankAccount.model;

import lombok.Data;

@Data
public class BankAccount {
    private String accountId;
    private String accountNumber;
    private String accountType;
    private double balance;
}
