package com.example.demoWeb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web")
public class HelloController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello, World!!";
    }

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1,"Lina",26,99,"lina123@gmail.com");
        return student;
    }

    @GetMapping("/welcome/{name}")
    public String getWelcome(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/welcome/{name}/{age}")
    public String getWelcome1(@PathVariable String name, @PathVariable int age) {
        return "Hello " + name + ", age is : " + age;
    }

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam String name) {
        return "Hello " + name + " from single request param.";
    }

    @GetMapping("/greeting/data")
    public String getGreeting1(@RequestParam String name, @RequestParam int age) {
        return "Hi " + name + " and your age is " + age + " from multiple request params.";
    }

}
