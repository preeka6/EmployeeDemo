<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Spring MVC Demo</title>
 </head>
 <body>
  <h2>Add Employee Data</h2>
  <form:form method="POST" action="save.html">
      <table>
       <tr>
           <td><form:label path="id">Employee ID:</form:label></td>
           <td><form:input path="id" value="${employee.id}" readonly="true"/></td>
       </tr>
       <tr>
           <td><form:label path="name">Employee Name:</form:label></td>
           <td><form:input path="name" value="${employee.name}"/></td>
       </tr>
       <tr>
           <td><form:label path="age">Employee Age:</form:label></td>
           <td><form:input path="age" maxlength="2" value="${employee.age}"/></td>
       </tr>
       <tr>
           <td><form:label path="salary">Employee Salary:</form:label></td>
           <td><form:input path="salary" value="${employee.salary}"/></td>
       </tr>
       <tr>
         <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
   </table> 
  </form:form>
  
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
  
 </body>
</html>