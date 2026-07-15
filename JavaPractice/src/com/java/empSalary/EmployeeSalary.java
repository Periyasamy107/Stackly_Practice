package com.java.empSalary;

public class EmployeeSalary {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       EMPLOYEE SALARY PROGRAM");
        System.out.println("========================================");

        System.out.println("Intern : ");
        System.out.println("----------------------------------------");
        Intern intern = new Intern(11, "Doma", 10000);
        intern.display();
        System.out.println();

        System.out.println("Developer : ");
        System.out.println("----------------------------------------");
        Developer developer = new Developer(21, "Lina", 20000);
        developer.display();
        System.out.println();

        System.out.println("Manager : ");
        System.out.println("----------------------------------------");
        Manager manager = new Manager(31, "Raju", 40000);
        manager.display();
        System.out.println();

        System.out.println("----------------------------------------");

    }

}
