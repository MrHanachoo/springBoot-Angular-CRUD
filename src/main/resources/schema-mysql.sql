DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  empId VARCHAR(10) NOT NULL,
  empName VARCHAR(100) NOT NULL,
  empDesignation VARCHAR(100) NOT NULL,
  empSalary DOUBLE NOT NULL
);