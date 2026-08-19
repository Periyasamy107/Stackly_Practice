package com.example.bankAOP;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BankService {

    private Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int accountNumber, String name, double balance) {
        Account account = new Account(1,"Sam",8000);
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully.");
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if(account==null) {
            System.out.println("Account not found : deposit");
            return;
        }
        account.setBalance(account.getBalance() + amount);
        System.out.println("Account Deposit : Rs." + amount);
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if(account == null) {
            System.out.println("Account not found : withdraw");
        }
        if(account.getBalance()<amount) {
            System.out.println("Insufficient Balance");
            return;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Amount Withdraw : Rs." + amount);
    }

    public void checkBalance(int accountNumber) {
        Account account = accounts.get(accountNumber);
        if(account==null) {
            System.out.println("Account not found : checkBalance");
            return;
        }
        System.out.println("Current Balance : " + account.getBalance());
    }

}
