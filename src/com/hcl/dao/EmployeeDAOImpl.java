package com.hcl.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.model.Employee;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	public final static Logger log = Logger.getLogger(EmployeeDAOImpl.class);


 @Autowired
 private SessionFactory sessionFactory;
 
 public void addEmployee(Employee employee) {
	 try {
		 sessionFactory.getCurrentSession().saveOrUpdate(employee);
	 }catch(Exception e)
	 {
		 System.out.println("EXCEPTION CAUGHT....");
	 }
 }
 
public void updateEmployee(List<Employee> employee) throws Exception {
	 Session session = sessionFactory.getCurrentSession();
   
     int i=0;
     for (Employee emp:employee){
    	 if(emp.getAge()<0) {
    		 throw new Exception("Age invalid");
    	 }
    	 session.saveOrUpdate(emp);

        	 session.flush();
        	 session.clear();         
     }
 }

 @SuppressWarnings("unchecked")
 public List<Employee> listEmployees() {
  return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
 }
 
 @SuppressWarnings("unchecked")
 public List<Employee> searchEmployees(Employee employee) {
	 	
	 Criteria c = sessionFactory.getCurrentSession().createCriteria(Employee.class);
	 if(employee.getId() != null) 
         c.add(Restrictions.eq("id", employee.getId()));
     if(employee.getName() != null && !employee.getName().equals("")) 
         c.add(Restrictions.eq("name", employee.getName()));
     if(employee.getAge() != null) 
         c.add(Restrictions.eq("age", employee.getAge()));
     if(employee.getSalary() != null) 
         c.add(Restrictions.eq("salary", employee.getSalary()));
          
     log.debug("result list size is...."+c.list().size());
     return (List<Employee>) c.list();
 }
 
 public Employee getEmployee(int id) {
  return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
 }

 public void deleteEmployee(Employee employee) {
  sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE id = "+employee.getId()).executeUpdate();
 }

 @Override
 public void updateEmployeeCustomRollback(List<Employee> employee) {
	 int i=0;
	 Session session = sessionFactory.getCurrentSession();
	 for (Employee emp:employee){
		 try {
			 if(emp.getAge()<0) {

				 throw new Exception("Age invalid");

			 }
			 session.saveOrUpdate(emp);

		 } catch (Exception e) {
			 log.error("updateEmployee() - could not update employee "+ employee.get(i) + "Exception -"+ e.getMessage());
		 }
			 session.flush();
			 session.clear();
	 }	
 }
}
