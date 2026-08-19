package com.example.bank;

import com.example.bank.model.BankAccount;
import com.example.bank.service.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankAccountAopApplication {

	public static void main(String[] args) {
        SpringApplication.run(BankAccountAopApplication.class, args);
	}

    @Bean
    CommandLineRunner run(BankAccountService service) {

        return args -> {

            BankAccount account = new BankAccount("ACC101", "Sam", 50000);

            System.out.println("==================================");
            System.out.println("BANK ACCOUNT MANAGEMENT SYSTEM");
            System.out.println("==================================");

            System.out.println("\n1. CREATE ACCOUNT");
            System.out.println("----------------------------------");
            service.createAccount(account);

            System.out.println("\n2. DEPOSIT");
            System.out.println("----------------------------------");
            service.deposit(account, 10000);

            System.out.println("\n3. VIEW BALANCE");
            service.viewBalance(account);

            System.out.println("\n4. SUCCESSFUL WITHDRAW");
            System.out.println("----------------------------------");
            try{
                service.withdraw(account, 15000);
            } catch (Exception e) {
                System.out.println("Operation Failed : " + e.getMessage());
            }

            System.out.println("\n5. VIEW BALANCE");
            service.viewBalance(account);

            System.out.println("\n6. FAILED WITHDRAW");
            System.out.println("----------------------------------");
            try {
                service.withdraw(account, 100000);
            } catch (Exception e) {
                System.out.println("Operation Failed : " + e.getMessage());
            }
        };

    }

}
