package com.stream;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {

        EmployeeRecords empRecords = new EmployeeRecords();

        List<EmployeeBase> employees = empRecords.emps;

//        // 1) Normal printing
//        employees.stream()
//                .forEach(emplyee -> System.out.println(emplyee));



//        // 2) salary < 30000, emp name printing
//        employees.stream()
//                .filter(emp -> emp.salary < 30000)
//                .forEach(emp -> System.out.println(emp.name));



//        // 3) emp name contains 'o' letter
//        employees.stream()
//                .filter(emp -> emp.name.contains("o"))
//                .forEach(System.out::println);


//        // 4) emp name convert into upper case
//        employees.stream()
//                .map(emp -> emp.name.toUpperCase())
//                .forEach(System.out::println);


        // 5) emp salary < 30k then added extra 10k
        employees.forEach(System.out::println);

        System.out.println();
        System.out.println();

        employees.stream()
                .map(emp -> {
                    if(emp.salary < 30000) {
                        emp.salary += 10000;
                    }
                    return emp;
                })
                .forEach(System.out::println);

    }
}
