package com.mrhanachoo.controller;

import com.mrhanachoo.model.Employee;
import com.mrhanachoo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;



    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Employee> firstPage() {
        return employeeService.getAllEmployees();
    }





}
