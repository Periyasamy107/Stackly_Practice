package com.java.atm;

public class ATMOperations extends Account{

    public static final double MIN_BALANCE = 1000;

    ATMOperations(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }

    public void withdraw(double withdrawalAmount) {
        if(withdrawalAmount <= 0) {
            System.out.println("Negative amount transaction not possible");
        } else if(withdrawalAmount > balance) {
            System.out.println("Insufficient balance");
        } else if((balance - withdrawalAmount) < MIN_BALANCE) {
            System.out.println("Minimum balance should be maintained. So no withdrawal.");
        } else {
            balance = balance - withdrawalAmount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void deposit(double depositAmount) {
        if(depositAmount <= 0) {
            System.out.println("Deposit amount should be greater than zero");
            return;
        }
        balance += depositAmount;
        System.out.println("Deposit successful");
    }

    public void checkBalance() {
        System.out.println("Balance : " + balance);
    }
}
