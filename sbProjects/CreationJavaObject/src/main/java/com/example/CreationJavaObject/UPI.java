package com.example.CreationJavaObject;

import org.springframework.stereotype.Component;

@Component("smsMessage")
public class UPI implements Transaction {

    @Override
    public void sendMessage() {
        System.out.println("\n======================");
        System.out.println("UPI Message");
        System.out.println("======================\n");
    }

}
