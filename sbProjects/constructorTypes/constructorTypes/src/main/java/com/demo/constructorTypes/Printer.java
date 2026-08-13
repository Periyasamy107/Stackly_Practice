package com.demo.constructorTypes;

import org.springframework.stereotype.Component;

@Component
public class Printer {
    public void print() {
        System.out.println("Printing Documents.");
    }
}
