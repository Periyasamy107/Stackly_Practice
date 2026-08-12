package com.demo.ObjCreationJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObjCreationJavaApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObjCreationJavaApplication.class, args);

        System.out.println();
        UPI upi = context.getBean(UPI.class);
        System.out.println("upi : " + upi.hashCode());
        System.out.println();

        ATM atm = context.getBean(ATM.class);
        System.out.println("atm : " + atm.hashCode());
        System.out.println();

        UPI upi1 = context.getBean(UPI.class);
        System.out.println("upi1 : " + upi1.hashCode());
        System.out.println();

        UPI upi2 = context.getBean(UPI.class);
        System.out.println("upi2 : " + upi2.hashCode());
        System.out.println();


	}

}
