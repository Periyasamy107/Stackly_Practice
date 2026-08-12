package com.demo.ObjCreationJava;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TransactionManagement {

    @Autowired
    @Qualifier("upiTransaction")
    private Transaction transaction1;

    @Autowired
    private Transaction transaction2;

    @PostConstruct
    public void show() {
        transaction1.getMessage();
        transaction2.getMessage();
    }

}
