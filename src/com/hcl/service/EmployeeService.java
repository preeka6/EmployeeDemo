package com.hcl.service;

import java.util.List;
import com.hcl.model.Employee;


public interface EmployeeService {
 
 public void addEmployee(Employee employee) throws Exception;
 
 public void updateEmployee(List<Employee> employee) throws Exception;
 
 public void updateEmployeeCustomRollback(List<Employee> employee) throws Exception;

 public List<Employee> listEmployees();
 
 public List<Employee> searchEmployees(Employee employee);
 
 public Employee getEmployee(int id);
 
 public void deleteEmployee(Employee employee);
}