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

<c:set var="user" value="${sessionScope.user}"/>
<b>View Profile for: <c:out value="${user.username}"/> </b>

<table>
	<tr>
	  <td>ID:</td><td><c:out value="${user.id}" /></td>
	</tr>
	<tr>  
	  <td>First Name:</td><td><c:out value="${user.firstName}" /></td>
	</tr>
	<tr>
	  <td>Last Name:</td><td><c:out value="${user.lastName}" /></td>
	</tr>
	<tr>
   	  <td>Password:</td><td><c:out value="${user.password}" /></td>
   	</tr>	
</table>

</body>
</html>