package com.demo.constructorTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private Printer printer;

    @Autowired
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void printing() {
        printer.print();
    }
}
