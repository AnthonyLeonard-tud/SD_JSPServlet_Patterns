<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.sampleapp.business.User" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
</head>
<body>

<b>Table using java code...</b>

<table>

<tr> <th>ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Password</th>

<%
List<User> users;
users = (List<User>)(request.getSession().getAttribute("users"));

if (users != null){

  for (User u : users){ 
%>

	<tr>
	  <td><%=u.getId()%></td>
	  <td><%=u.getUsername()%></td>
	  <td><%=u.getFirstName()%></td>
	  <td><%=u.getLastName()%></td>
	  <td><%=u.getPassword()%></td>
	</tr>

<% 
  }
}
%>

</table>

<br/>
<b>Table using JSTL...</b>

<table>

<tr> <th>ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>Password</th>

<c:forEach var="user" items="${sessionScope.users}">
	<tr>
	  <td><c:out value="${user.id}" /></td>
	  <td><c:out value="${user.username}" /></td>
	  <td><c:out value="${user.firstName}" /></td>
   	  <td><c:out value="${user.lastName}" /></td>	  
	  <td><c:out value="${user.password}" /></td>	  
	</tr>  
</c:forEach>

</table>

</body>
</html>