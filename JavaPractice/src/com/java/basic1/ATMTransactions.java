package com.java.basic1;

import java.util.Scanner;

public class ATMTransactions {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("==================================================");
        System.out.println("           ATM TRANSACTION PROGRAM               ");
        System.out.println("==================================================");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        ATMTransactions atm = new ATMTransactions();

        boolean isRunning = true;
        int balance = 10000;
        int minBalance = 1000;

        System.out.println("Initial Balance : " + balance);

        while(isRunning) {
            System.out.println("1) Deposit ");
            System.out.println("2) Withdraw ");
            System.out.println("3) Balance Enquiry ");
            System.out.println("4) Exit");
            System.out.print("Please enter from the options : ");
            int options = scanner.nextInt();

            switch(options) {
                case 1 -> {
                    System.out.println();
                    balance = atm.deposit(balance, scanner);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println();
                    balance = atm.withdraw(balance, minBalance, scanner);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println();
                    atm.balanceEnquiry(balance);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println();
                    isRunning = false;
                    System.out.println("Exiting the program");
                }
                default -> {
                    System.out.println();
                    System.out.println("Please enter either 1 or 2 or 3 or 4.");
                }
            }

            System.out.println("--------------------------------------------------");
        }
        scanner.close();
    }

    public int deposit(int balance, Scanner scanner) {
        System.out.print("Enter the deposit amount : ");
        int amount = scanner.nextInt();
        balance += amount;
        System.out.println("Deposited Successful ");
        return balance;
    }

    public int withdraw(int balance, int minBalance, Scanner scanner) {
        System.out.print("Enter the withdraw amount : ");
        int amount = scanner.nextInt();
        if(amount>balance) {
            System.out.println("Insufficient Balance");
        } else if((balance - amount) < minBalance) {
            System.out.println("Minimum Balance Not Maintained \nPlease deposit the money");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful ");
        }
        return balance;
    }

    public void balanceEnquiry(int balance) {
        System.out.println("Current Balance : " + balance);
    }

}
