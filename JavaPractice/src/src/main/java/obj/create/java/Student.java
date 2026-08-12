package src.main.java.obj.create.java;

public class Student {

    private int id;
    private String name;

    public Student() {
        System.out.println("Constructor1");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student [id="+id+", name="+name+"]");
    }
}
