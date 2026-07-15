package com.java.atm;

public class ATMService extends ATMOperations{

    public static final int SECRET_PIN = 1007;

    ATMService(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }

    public void transactions(int pin, String type, double amount) {
        int pinValidation = 0;
        if(SECRET_PIN == pin) pinValidation = 1;
        switch (pinValidation) {
            case 1 -> {
                switch (type) {
                    case "withdraw" -> {
                        withdraw(amount);
                    }
                    case "deposit" -> {
                        deposit(amount);
                    }
                    default -> {
                        System.out.println("Please enter either 'withdraw' or 'deposit'");
                    }
                }
            }
            case 0 -> {
                System.out.println("PIN is invalid, no operations performed");
            }
        }
    }

}
