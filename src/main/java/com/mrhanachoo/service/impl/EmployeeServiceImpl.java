package com.mrhanachoo.service.impl;

import com.mrhanachoo.dao.EmployeeDao;
import com.mrhanachoo.model.Employee;
import com.mrhanachoo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void insertEmployee(Employee emp) {
        employeeDao.insertEmployee(emp);

    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        employeeDao.insertEmployees(employees);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        Employee employee = employeeDao.getEmployeeById(empId);
        System.out.println(employee);
        return employee;
    }
}
