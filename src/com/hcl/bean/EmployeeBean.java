package com.hcl.bean;

import java.util.List;

import com.hcl.model.Employee;

public class EmployeeBean {
	private Integer id;
	 private String name;
	 private Integer age;
	 private Long salary;
	 private List<Employee> employee;
	 private String errmsg;
	 public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

		public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	 
	 public Long getSalary() {
	  return salary;
	 }
	 public void setSalary(Long salary) {
	  this.salary = salary;
	 }
	 public Integer getId() {
	  return id;
	 }
	 public void setId(Integer id) {
	  this.id = id;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 public Integer getAge() {
	  return age;
	 }
	 public void setAge(Integer age) {
	  this.age = age;
	 }
}
