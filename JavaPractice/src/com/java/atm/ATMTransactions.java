package com.java.atm;

public class ATMTransactions {

    public static void main(String[] args) {

        ATMService atm = new ATMService("Reena", 10000);

        System.out.println("=================================");
        System.out.println("    ATM TRANSACTIONS PROGRAM     ");
        System.out.println("=================================");
        System.out.println();

        System.out.println("Initial Balance : " + 10000);
        System.out.println();

        System.out.println("Withdrawal amount : " + (-1000));
        atm.transactions(1007, "withdraw", -1000);
        atm.checkBalance();
        System.out.println();

        System.out.println("Withdrawal amount : " + 1000);
        atm.transactions(1007, "withdraw", 1000);
        atm.checkBalance();
        System.out.println();

        System.out.println("Withdrawal amount : " + 11000);
        atm.transactions(1007, "withdraw", 11000);
        atm.checkBalance();
        System.out.println();

        System.out.println("Withdrawal amount : " + 8500);
        atm.transactions(1007, "withdraw", 8500);
        atm.checkBalance();
        System.out.println();

        System.out.println("Withdrawal amount : " + 7000);
        atm.transactions(1007, "withdraw", 7000);
        atm.checkBalance();
        System.out.println();

        System.out.println("Deposited amount : " + (-2000));
        atm.transactions(1007, "deposit", -2000);
        atm.checkBalance();
        System.out.println();

        System.out.println("Deposited amount : " + 3000);
        atm.transactions(1007, "deposit", 3000);
        atm.checkBalance();
        System.out.println();

        atm.transactions(1007, "error", 3000);
        atm.transactions(1234, "withdraw", 3000);

        System.out.println("---------------------------------------------------");

    }

}
