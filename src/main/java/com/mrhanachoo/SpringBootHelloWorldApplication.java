package com.mrhanachoo;

import com.mrhanachoo.model.Employee;
import com.mrhanachoo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootHelloWorldApplication {


    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootHelloWorldApplication.class, args);
        EmployeeService employeeService = context.getBean(EmployeeService.class);


        List<Employee> tempEmployees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);


        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);

        employeeService.insertEmployees(tempEmployees);

    }

    private  List<Employee> createList() {

        List<Employee> tempEmployees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);


        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);

        employeeService.insertEmployees(tempEmployees);

        return tempEmployees;
    }

}
