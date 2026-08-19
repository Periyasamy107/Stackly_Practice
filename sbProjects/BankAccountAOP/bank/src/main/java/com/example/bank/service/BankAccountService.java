package com.example.bank.service;

import com.example.bank.annotation.SensitiveOperation;
import com.example.bank.model.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    public void createAccount(BankAccount account) {
        System.out.println("[BANK] Account created : " + account.getAccountNumber());
    }

    public double deposit(BankAccount account, double amount) {
        if(amount<=0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        double newBalance = account.getBalace() + amount;
        account.setBalace(newBalance);
        System.out.println("[BANK] Deposited : Rs." + amount);
        return newBalance;
    }

    @SensitiveOperation
    public double withdraw(BankAccount account, double amount) {
        if(amount<=0) {
            throw new IllegalArgumentException("Withdraw amount must be greater than zero");
        }
        if(amount > account.getBalace()) {
            throw new IllegalArgumentException("Insufficient Balance");
        }
        double newBalance = account.getBalace() - amount;
        account.setBalace(newBalance);
        System.out.println("[BANK] Withdrawn Amount : Rs." + amount);
        return newBalance;
    }

    public double viewBalance(BankAccount account) {
        System.out.println("[BANK] Current Balance : Rs." + account.getBalace());
        return account.getBalace();
    }

}
