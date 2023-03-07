package com.rc.training.repo;

import com.rc.training.model.Employee;

import java.util.HashMap;
import java.util.List;

public class EmployeeRepository {
    HashMap<Integer, Employee> employees;
    public EmployeeRepository(){
        employees = new HashMap<>();
    }

    public List<Employee> getEmployees() {
        return employees.values().stream().toList();
    }

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public void addEmployees(Employee... emps) {
        for(Employee emp: emps) {
            addEmployee(emp);
        }
    }
    public void clean() {
        employees.clear();
    }
}
