package obj.create.xml;

public class Employee {

    private int id;
    private String name;
    private double salary;

    public Employee() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void employeeDisplay() {
        System.out.println("Employee [id="+id+", name="+name+", salary="+salary+"]");
    }
}
