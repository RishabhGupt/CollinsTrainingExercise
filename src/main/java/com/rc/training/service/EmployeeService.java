package com.rc.training.service;

import com.rc.training.error_messages.Messages;
import com.rc.training.model.Employee;
import com.rc.training.repo.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    EmployeeRepository repository;
    Messages messages;
    EmployeeService(EmployeeRepository repository, Messages messages) {
        this.repository = repository;
        this.messages = messages;
    }
    public void logEmployees() {
        repository.getEmployees().forEach(System.out::println);
    }
    public void init() {
        System.out.println("\n\tInitializing repository with dummy data");
        repository.addEmployees(
                new Employee(1, "Alex", 56000.20D, "Engineer"),
                new Employee(2, "Bob", 759000.10D, "Manager"),
                new Employee(3, "Alice", 36950.00D, "Associate"),
                new Employee(4, "John", 69000.00D, "Senior HR"),
                new Employee(5, "Vikram", 653200.00D, "Senior Engineer"),
                new Employee(6, "Miami", 56810.00D, "Associate"),
                new Employee(7, "Aman", 56500.65D, "Engineer"),
                new Employee(8, "Alice", 756086.89D, "Manager"));
    }


    public boolean validateEmployee(Employee emp) {
        List<Employee> employees = repository.getEmployees();
        if(emp.getId()<0) {
            System.out.println(messages.getNegativeIdMessage());
            return false;
        }
        if(employees.stream().anyMatch(employee -> employee.getId()==emp.getId())) {
            System.out.println(messages.getDuplicateIdMessage());
            return false;
        }
        return true;
    }
    public void clearRepository() {
        repository.clean();
        System.out.println("Repository cleaned successfully");
    }
    public void addEmployee(Employee emp) {
        if(validateEmployee(emp)) repository.addEmployee(emp);
    }
}
