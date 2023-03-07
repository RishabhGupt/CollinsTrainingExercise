package com.rc.training;

import com.rc.training.model.Employee;
import com.rc.training.service.EmployeeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        EmployeeService service = (EmployeeService) context.getBean("service");
        service.logEmployees();
        service.addEmployee(new Employee(-1, "Aman", 68986D, "Trainee"));
        service.addEmployee(new Employee(1, "Reddy", 85986D, "Engineer"));
        service.addEmployee(new Employee(10, "Arjun", 195086D, "Manager"));
    }
}
