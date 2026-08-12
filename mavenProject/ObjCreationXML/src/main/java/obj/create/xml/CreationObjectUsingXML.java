package obj.create.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreationObjectUsingXML {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("createObjXML.xml");

        Student student = context.getBean(Student.class);
        student.studentDisplay();

        Employee employee1 = context.getBean("Employee1", Employee.class);
        employee1.employeeDisplay();

        Employee employee2 = context.getBean("Employee2", Employee.class);
        employee2.employeeDisplay();

    }

}
