package com.example.codebufferspringboot.service;

import com.example.codebufferspringboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(String employeeId);

    String deleteByName(String firstName);

}
