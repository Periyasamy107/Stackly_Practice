package com.demo.LombokBankAccount.service;

import com.demo.LombokBankAccount.model.BankAccount;
import com.demo.LombokBankAccount.model.Customer;
import com.demo.LombokBankAccount.model.Transaction;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    public void displayBankService(Transaction transaction) {
        System.out.println();
        System.out.println("==================================");
        System.out.println("     CUSTOMER DETAILS : ");
        System.out.println("==================================");
        System.out.println("Customer ID : " + transaction.getCustomer().getCustomerId());
        System.out.println("Customer Name : " + transaction.getCustomer().getCustomerName());
        System.out.println("Customer City : " + transaction.getCustomer().getCity());
        System.out.println();

        System.out.println();
        System.out.println("==================================");
        System.out.println("     BANK ACCOUNT DETAILS : ");
        System.out.println("==================================");
        System.out.println("Account ID : " + transaction.getBankAccount().getAccountId());
        System.out.println("Account Number : " + transaction.getBankAccount().getAccountNumber());
        System.out.println("Account Type : " + transaction.getBankAccount().getAccountType());
        System.out.println("Account Balance : " + transaction.getBankAccount().getBalance());
        System.out.println();

        System.out.println();
        System.out.println("==================================");
        System.out.println("     TRANSACTION DETAILS : ");
        System.out.println("==================================");
        System.out.println("Transaction ID : " + transaction.getTransactionId());
        System.out.println("Bank Account Number : " + transaction.getBankAccount().getAccountNumber());
        System.out.println("Bank Account Type : " + transaction.getBankAccount().getAccountType());
        System.out.println("Customer Name : " + transaction.getCustomer().getCustomerName());
        System.out.println("Transaction Type : " + transaction.getTransactionType());
        System.out.println("Transaction Amount : " + transaction.getAmount());
        System.out.println();

    }


    @PostConstruct
    public void getResult() {
        Customer customer = Customer.builder()
                .customerId("cust01")
                .customerName("Lina")
                .city("Salem")
                .build();

        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountId("ba01");
        bankAccount.setAccountNumber("CAN956421");
        bankAccount.setAccountType("Savings");
        bankAccount.setBalance(10000);


        Transaction transaction = Transaction.builder()
                .transactionId("trans01")
                .bankAccount(bankAccount)
                .customer(customer)
                .transactionType("UPI")
                .amount(2000)
                .build();

        BankAccountService service = new BankAccountService();
        service.displayBankService(transaction);
    }

}
