import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApplication {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Employee employee = context.getBean(Employee.class);
        employee.display();

        List<Employee> employeeList = (List<Employee>) context.getBean("getEmployees");
//        employeeList.forEach(employee1 -> employee1.display());
        employeeList.forEach(Employee::display);

    }

}
