package com.mrhanachoo.service;

import com.mrhanachoo.model.Employee;

import java.util.List;

public interface EmployeeService {

    void insertEmployee(Employee emp);
    void insertEmployees(List<Employee> employees);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(String empid);

}
