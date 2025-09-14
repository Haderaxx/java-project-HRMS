package com.hrms.service;

import com.hrms.dao.EmployeeDAO;
import com.hrms.model.Employee;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void addEmployee(Employee emp) {
        employeeDAO.addEmployee(emp);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee findEmployee(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public boolean removeEmployee(int id) {
        return employeeDAO.deleteEmployee(id);
    }
}
