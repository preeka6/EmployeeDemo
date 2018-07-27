package com.hcl.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.EmployeeDAO;
import com.hcl.model.Employee;

@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
	
public final static Logger log = Logger.getLogger(EmployeeServiceImpl.class);


 @Autowired
 private EmployeeDAO employeeDao;
 
 @Transactional(rollbackFor=Exception.class)
 public void addEmployee(Employee employee) throws Exception {
  employeeDao.addEmployee(employee);
 }
 

 @Transactional(rollbackFor=Exception.class)
 public void updateEmployee(List<Employee> employee) throws Exception {
  employeeDao.updateEmployee(employee);
 }
 
 public List<Employee> listEmployees() {
  return employeeDao.listEmployees();
 }
 
 public List<Employee> searchEmployees(Employee employee) {
	 System.out.println("Inside search employeeee of serviceIMPL......");		
  return employeeDao.searchEmployees(employee);
 }

 public Employee getEmployee(int id) {
  return employeeDao.getEmployee(id);
 }
 
 public void deleteEmployee(Employee employee) {
  employeeDao.deleteEmployee(employee);
 }

@Transactional
@Override
public void updateEmployeeCustomRollback(List<Employee> employee) throws Exception {
     employeeDao.updateEmployeeCustomRollback(employee);
	
}

}