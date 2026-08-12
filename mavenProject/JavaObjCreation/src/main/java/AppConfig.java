import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppConfig {

    @Bean
    public Employee getEmployee() {
        Employee employee = new Employee();
        employee.setId(10);
        employee.setName("Sam");
        return employee;
    }

    @Bean
    public List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setId(11);
        employee1.setName("Lina");

        Employee employee2 = new Employee();
        employee2.setId(12);
        employee2.setName("Veena");

        employees.add(employee1);
        employees.add(employee2);

        return employees;
    }

}
