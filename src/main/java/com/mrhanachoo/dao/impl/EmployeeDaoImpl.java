package com.mrhanachoo.dao.impl;

import com.mrhanachoo.dao.EmployeeDao;
import com.mrhanachoo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao  {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insertEmployee(Employee emp) {
        String sql = "INSERT INTO employee " +
                "(empId, empName, empDesignation, empSalary) VALUES (?, ?, ?, ?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                emp.getEmpId(), emp.getName(), emp.getDesignation(), emp.getSalary()
        });
    }

    @Override
    public void insertEmployees(List<Employee> employees) {
        String sql = "INSERT INTO employee " + "(empId, empName, empDesignation, empSalary) VALUES (?, ?, ?, ?)";

        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Employee employee = employees.get(i);
                ps.setString(1, employee.getEmpId());
                ps.setString(2, employee.getName());
                ps.setString(3, employee.getDesignation());
                ps.setString(4, String.valueOf(employee.getSalary()));
            }

            public int getBatchSize() {
                return employees.size();
            }
        });

    }

    @Override
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Employee> result = new ArrayList<>();

        for(Map<String, Object> row:rows){
            Employee emp = new Employee();
            emp.setEmpId((String)row.get("empId"));
            emp.setName((String)row.get("empName"));
            emp.setDesignation((String)row.get("empDesignation"));
            emp.setSalary((Double) row.get("empSalary"));
            result.add(emp);
        }

        return result;
    }

    @Override
    public Employee getEmployeeById(String empId) {
        String sql = "SELECT * FROM employee WHERE empId = ?";

        return (Employee)getJdbcTemplate().queryForObject(sql, new Object[]{empId}, new RowMapper<Employee>(){
            @Override
            public Employee mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Employee emp = new Employee();
                emp.setEmpId(rs.getString("empId"));
                emp.setName(rs.getString("empName"));
                emp.setDesignation(rs.getString("empDesignation"));
                emp.setSalary(new Double(rs.getString("empSalary")));
                return emp;
            }
        });
    }
}
