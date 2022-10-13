package com.example.codebufferspringboot.controller;

import com.example.codebufferspringboot.entity.Employee;
import com.example.codebufferspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Content Negotiation using Http Headers - @PostMapping(value = "/saveEmployee",produces = MediaType.APPLICATION_XML_VALUE)
    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }

    //Content Negotiation using Http Headers - @GetMapping(value = "/getEmployee",produces = MediaType.APPLICATION_XML_VALUE)
    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable("id") String employeeId)
    {
        return employeeService.getEmployeeById(employeeId);
    }
    @DeleteMapping("/deleteByFirstName/{name}")
    public String deleteByEmployeeName(@PathVariable("name") String firstName)
    {
        return employeeService.deleteByName(firstName);
    }

}
