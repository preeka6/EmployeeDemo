package com.hcl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{

 private static final long serialVersionUID = -723583058586873479L;
 
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 @Column(name = "ID")
 private Integer id;
 
 @Column(name="NAME")
 private String name;
 
 @Column(name="SALARY")
 private Long salary;
 
 @Column(name="AGE")
 private Integer age;

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

 public Long getSalary() {
  return salary;
 }

 public void setSalary(Long salary) {
  this.salary = salary;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Employee [id=").append(id).append(", name=").append(name).append(", salary=").append(salary)
			.append(", age=").append(age).append("]");
	return builder.toString();
}
}