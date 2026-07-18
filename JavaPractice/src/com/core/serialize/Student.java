package com.core.serialize;

import java.io.Serializable;

public class Student implements Serializable {

    public static final long serialVersionUID = 1L;

    private String name;
    private int id;

    private transient String password;

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student {Name = " + name + ", ID = " + id + ", Password = " + password;
    }

}
