package obj.create.xml;

public class Student {

    private int id;
    private String name;

    public Student() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void studentDisplay() {
        System.out.println("Student [id="+id+", name="+name+"]");
    }

}
