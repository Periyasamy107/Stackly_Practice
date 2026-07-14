package com.java.fileReadAndExp;

public class SampleCustomerProgram {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("CUSTOM EXCEPTION PROGRAM PRACTICE");
        System.out.println("==================================");
        System.out.println();

        String[] names = {"Ram", "Tom", "Lina"};
        boolean isCustomerPresent = false;

        for(String name : names) {
            if(name.equalsIgnoreCase("Lina")){
                isCustomerPresent = true;
            }
        }

        try{
            if(isCustomerPresent){
                System.out.println("Customer is 'PRESENT' in the array");
            } else {
                throw new CustomerNotFoundException("Customer 'NOT' found in the array");
            }
        } catch (CustomerNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println();
        System.out.println("----------------------------------");

    }

}
