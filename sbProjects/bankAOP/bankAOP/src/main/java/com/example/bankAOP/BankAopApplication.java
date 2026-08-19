package com.example.bankAOP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAopApplication implements CommandLineRunner {

    private BankService bankService;

    public BankAopApplication(BankService bankService) {
        this.bankService = bankService;
    }

	public static void main(String[] args) {
        SpringApplication.run(BankAopApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        bankService.createAccount(100,"Sam",5000);
        bankService.deposit(100,5000);
        bankService.withdraw(100,3500);
        bankService.checkBalance(100);
    }
}
