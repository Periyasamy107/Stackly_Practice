package com.example.demoAOP;

import com.example.demoAOP.service.PaymentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoAopApplication {

	public static void main(String[] args) {
        SpringApplication.run(DemoAopApplication.class, args);
	}

    @Bean
    CommandLineRunner run(PaymentService paymentService) {
        return args -> {
          try{
              paymentService.makePayment("Sam",2500,10000);
              paymentService.makePayment("Lina",-500,2000);
          } catch (Exception exception) {
              System.out.println("Handled in Main : " + exception.getMessage());
          }
        };
    }

}
