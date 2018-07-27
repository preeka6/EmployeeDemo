package com.hcl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;


import com.hcl.bean.EmployeeBean;
import com.hcl.model.Employee;
import com.hcl.service.EmployeeService;

@Controller
public class EmployeeController {
		
private final static Logger log = Logger.getLogger(EmployeeController.class);

 @Autowired
 private EmployeeService employeeService;
 
@RequestMapping(value = "/save", method = RequestMethod.POST)
public ModelAndView saveEmployee(@ModelAttribute("command")EmployeeBean employeeBean, BindingResult result) {
				
  Employee employee = prepareModel(employeeBean);
  try {
	employeeService.addEmployee(employee);
} catch (Exception e) {
	log.error("saveEmployee() - could not save employee " +employee.toString() + "- Exception -"+ e.getMessage());
	  return new ModelAndView("error");
}
  
  return new ModelAndView("redirect:/add.html");
 }

@RequestMapping(value = "/update", method = RequestMethod.POST)
public ModelAndView updateEmployee(@ModelAttribute("employeeBean")EmployeeBean employeeBean, BindingResult result) {
	
		List<Employee> emp = employeeBean.getEmployee();
		
		try {
			employeeService.updateEmployee(emp);
		} catch (Exception e) {
			log.error("updateEmployee() - could not update employee " +emp.toString() + "- Exception -"+ e.getMessage());
			  return new ModelAndView("error");
		}
  
  return new ModelAndView("redirect:/add.html");
  
 }

@RequestMapping(value = "/updateWithRollback", method = RequestMethod.POST)
public ModelAndView updateEmployeeWithCustomRollBack(@ModelAttribute("employeeBean")EmployeeBean employeeBean, BindingResult result) {
	
		List<Employee> emp = employeeBean.getEmployee();
		
		try {
			employeeService.updateEmployeeCustomRollback(emp);
		} catch (Exception e) {
			log.error("updateEmployeeupdateEmployeeCustomRollback() - could not update employee " +emp.toString() + "- Exception -"+ e.getMessage());
		}
  
  return new ModelAndView("redirect:/add.html");
 }
 @RequestMapping(value="/employees", method = RequestMethod.GET)
 public ModelAndView listEmployees() {
	 
	 System.out.println("Inside list employeeee");		
		
  Map<String,Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.listEmployees()));
  return new ModelAndView("employeeList", model);
 }
 
 @RequestMapping(value="/getdata", method = RequestMethod.GET)
 public ModelAndView searchEmployees(@ModelAttribute("command")EmployeeBean employeeBean, BindingResult result) {
	 	 
  Employee employee = prepareModel(employeeBean);
		
  Map<String,Object> model = new HashMap<String, Object>();
  List<EmployeeBean> list = new ArrayList<EmployeeBean>();
  list = prepareListofBean(employeeService.searchEmployees(employee));
  model.put("employees",  list);
  
return new ModelAndView("employeeList", model);
 
 }

 @RequestMapping(value = "/add", method = RequestMethod.GET)
 public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
	
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employees",  prepareListofBean(employeeService.listEmployees()));
  return new ModelAndView("addEmployee", model);
 }
 
@RequestMapping(value = "/index", method = RequestMethod.GET)
public ModelAndView welcome(@ModelAttribute("command")EmployeeBean employeeBean,
		   BindingResult result) {
	
  log.debug("Inside welcome........");
	
  return new ModelAndView("index");
 }

@RequestMapping(value = "/delete", method = RequestMethod.GET)
public ModelAndView deleteEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {	
		
  employeeService.deleteEmployee(prepareModel(employeeBean));
  Map<String, Object> model = new HashMap<String, Object>();
  model.put("employee", null);
  model.put("employees",  prepareListofBean(employeeService.listEmployees()));
  return new ModelAndView("addEmployee", model);
 }

@RequestMapping(value = "/edit", method = RequestMethod.GET)
public ModelAndView editEmployee(@ModelAttribute("command")EmployeeBean employeeBean,
   BindingResult result) {
				
	 Map<String,Object> model = new HashMap<String, Object>();
	  model.put("employees",  prepareListofBean(employeeService.listEmployees()));
	  return new ModelAndView("editEmployee", model);
 }
 
 private Employee prepareModel(EmployeeBean employeeBean){
	 				
  Employee employee = new Employee();
  employee.setAge(employeeBean.getAge());
  employee.setName(employeeBean.getName());
  employee.setSalary(employeeBean.getSalary());
  employee.setId(employeeBean.getId());
  employeeBean.setId(null);
  return employee;
 }
 
 private List<EmployeeBean> prepareListofBean(List<Employee> employees){
	 			 
  List<EmployeeBean> beans = null;
  if(employees != null && !employees.isEmpty()){
   beans = new ArrayList<EmployeeBean>();
   EmployeeBean bean = null;
   for(Employee employee : employees){
    bean = new EmployeeBean();
    bean.setName(employee.getName());
    bean.setId(employee.getId());
    bean.setSalary(employee.getSalary());
    bean.setAge(employee.getAge());
    beans.add(bean);
   }
  }
  return beans;
 }
 
 private EmployeeBean prepareEmployeeBean(Employee employee){
	 		
  EmployeeBean bean = new EmployeeBean();
  bean.setAge(employee.getAge());
  bean.setName(employee.getName());
  bean.setSalary(employee.getSalary());
  bean.setId(employee.getId());
  return bean;
 }
}