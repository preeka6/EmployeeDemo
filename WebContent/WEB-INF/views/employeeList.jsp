<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<h3><a href="add.html">Add More Employee</a></h3>

<c:if test="${!empty employees}">
 <table align="left" border="1">
 <tr>
    <td align="center"><a href="edit.html">Edit</a> </td>
    </tr>
  <tr>
   <th>Employee ID</th>
   <th>Employee Name</th>
   <th>Employee Age</th>
   <th>Employee Salary</th>
  </tr>

  <c:forEach items="${employees}" var="employee">
   <tr>
    <td><c:out value="${employee.id}"/></td>
    <td><c:out value="${employee.name}"/></td>
    <td><c:out value="${employee.age}"/></td>
    <td><c:out value="${employee.salary}"/></td>
    <td align="center"><a href="delete.html?id=${employee.id}">Delete</a></td>    
   </tr>
  </c:forEach>
 </table>
</c:if>
<c:if test="${empty employees}">
	<table align="center" border="1">
  <tr>
   <th>No Matching Records Found !!!</th>
   </tr>
   </table>
</c:if>
</body>
</html>