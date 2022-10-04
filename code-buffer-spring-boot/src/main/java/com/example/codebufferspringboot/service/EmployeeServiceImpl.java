package com.example.codebufferspringboot.service;

import com.example.codebufferspringboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getEmployeeId() == null || employee.getEmailId().isEmpty())
        {
            employee.setEmployeeId(UUID.randomUUID().toString());//Setting employee Id
        }
        employeeList.add(employee);//Later store it in Employee List
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeList
                .stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(employeeId))
                .findFirst()
                .get();
    }

    @Override
    public String deleteByName(String firstName) {
        Employee employee = employeeList
                .stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase(firstName))
                .findFirst()
                .get();
        employeeList.remove(employee);
        return "Employee as been deleted!!!" + firstName;
    }

}
