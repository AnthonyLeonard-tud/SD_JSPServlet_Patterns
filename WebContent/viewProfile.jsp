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
<b>View Profile for: <c:out value="${user.username}"/></b>
<form method="post" action="UserController">
<table>
	<tr>
	  <td>ID:</td><td><input type="hidden" name="id" value="<c:out value="${user.id}" />"></input><c:out value="${user.id}" /></td>
	</tr>
	<tr>  
	  <td>First Name:</td><td><input type="text" name="firstName" value="<c:out value="${user.firstName}" />"></input></td>
	</tr>
	<tr>
	  <td>Last Name:</td><td><input type="text" name="lastName" value="<c:out value="${user.lastName}" />"></input></td>
	</tr>
	<tr>
	  <td>Last Name:</td><td><input type="text" name="username" value="<c:out value="${user.username}" />"></input></td>
	</tr>
	<tr>
   	  <td>Password:</td><td><input type="text" name="password" value="<c:out value="${user.password}" />"></input></td>
   	</tr>	
</table>
<input type="hidden" name="action" value="EditUserProfile" />
<input type="submit" value="Change My Profile" />
</form>
</body>
</html>