package com.demo.ObjCreationJava;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ATM implements Transaction{

    @Override
    public void getMessage() {
        System.out.println("ATM Transaction Message");
    }

}
