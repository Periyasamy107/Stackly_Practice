package com.example.CreationJavaObject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CreationJavaObjectApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(CreationJavaObjectApplication.class, args);

        ATM atm1 = context.getBean(ATM.class);
        ATM atm2 = context.getBean(ATM.class);

        System.out.println("\n======================");
        System.out.println(atm1 == atm2);
        System.out.println("======================\n");
	}

}
