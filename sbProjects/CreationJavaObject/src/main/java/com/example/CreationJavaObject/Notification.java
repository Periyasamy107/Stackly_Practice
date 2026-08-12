package com.example.CreationJavaObject;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Notification {

    @Autowired
    private Transaction messageService;

    @Autowired
    @Qualifier("smsMessage")
    private Transaction messageService1;

    @PostConstruct
    public void display() {
        messageService.sendMessage();
        messageService1.sendMessage();
    }

}
