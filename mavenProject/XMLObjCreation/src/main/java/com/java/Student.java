package com.java;

public class Student {

    private int id;
    private String name;
    private int age;

    public Student () {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("Student [id=" + id + ", name=" + name + ", age=" + age + "]");
    }

}
