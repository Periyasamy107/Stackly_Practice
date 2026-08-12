package multi.obj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultipleObjsCreationUsingXML {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("objCreationFile.xml");
        Employee emp1 = context.getBean("employee1", Employee.class);
        emp1.display();

        Employee emp2 = context.getBean("employee2", Employee.class);
        emp2.display();

    }
}
