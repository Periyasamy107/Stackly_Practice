package com.demo.ObjCreationJava;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("upiTransaction")
@Scope("prototype")
public class UPI implements Transaction{

    @Override
    public void getMessage() {
        System.out.println("UPI Transaction Message");
    }

}
