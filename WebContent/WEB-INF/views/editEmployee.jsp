<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<h3><a href="add.html">Add More Employee</a></h3>

<c:if test="${!empty employees}">
 <form:form method="POST" action="update.html" modelAttribute="employeeBean">
 <table align="left" border="1">
  <tr>
  <th></th>
   <th>Employee ID</th>
   <th>Employee Name</th>
   <th>Employee Age</th>
   <th>Employee Salary</th>
  </tr>

  <c:forEach items="${employees}" var="employee" varStatus="status">
   <tr>
   			  <td align="center">${status.count}</td>
              <td><input name = "employee[${status.index}].id" path="id" value="${employee.id}" readonly="true"/></td>
              <td><input name = "employee[${status.index}].name" path="name" value="${employee.name}"/></td>
              <td><input name = "employee[${status.index}].age" maxlength="2" path="age" value="${employee.age}"/></td>
              <td><input name = "employee[${status.index}].salary" path="salary" value="${employee.salary}"/></td>
   </tr>   
  </c:forEach>  
 </table>
 <tr>
         <td colspan="2">
         <input type="submit" action = "update.html" value="Submit"/></td>
   </tr>
    <tr>
         <td colspan="2">
         <input type="submit" formaction = "updateWithRollback.html" value="Save with Custom Rollback"/></td>
   </tr>
 </form:form>
</c:if>
<c:if test="${empty employees}">
	<table align="center" border="1">
  <tr>
   <th>No Matching Records Found !!!</th>
   </tr>
   </table>
</c:if>
<c:if test="${!empty employee.errmsg}">
	<table align="center" border="1">
  <tr>
   <th>Oops !!! Something went wrong. Please try again later.</th>
   </tr>
   </table>
</c:if>
</body>
</html>