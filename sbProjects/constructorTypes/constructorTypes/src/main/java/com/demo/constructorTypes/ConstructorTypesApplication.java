package com.demo.constructorTypes;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConstructorTypesApplication implements CommandLineRunner {

    private Car car;
    private Computer computer;

    public ConstructorTypesApplication(Car car, Computer computer) {
        this.car = car;
        this.computer = computer;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConstructorTypesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        car.drive();
        computer.printing();
    }
}




//@SpringBootApplication
//public class ConstructorTypesApplication {
//
//    private Car car;
//    private Computer computer;
//
//    public ConstructorTypesApplication(Car car, Computer computer) {
//        this.car = car;
//        this.computer = computer;
//    }
//
//	public static void main(String[] args) {
//        SpringApplication.run(ConstructorTypesApplication.class, args);
//	}
//
//    @PostConstruct
//    public void display() {
//        car.drive();
//        computer.printing();
//    }
//
//}
