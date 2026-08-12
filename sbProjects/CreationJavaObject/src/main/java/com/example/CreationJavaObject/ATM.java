package com.example.CreationJavaObject;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Scope("prototype")
public class ATM implements Transaction {

    @Override
    public void sendMessage() {
        System.out.println("\n======================");
        System.out.println("ATM Message");
        System.out.println("======================\n");
    }

}
