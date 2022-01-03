<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.springbootmvc.a5.entity.Store"%>

<html>
<head>

<title>Store Details</title>
</head>
<body bgcolor="#87ceff">
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //HTTP1.1 browser
	response.setHeader("Pragma", "no-cache"); //HTTP1.0 browser
	response.setHeader("Expires", "0"); //proxies
	%>

	<form align='center' action='http://localhost:1210/store/get/details'>
		<div align='center'>
			<input type='submit' value='Home' />
		</div>
	</form>

	<form align='center' action='http://localhost:1210/store/logout'>
		<div align='center'>
			<input type='submit' value='Logout' />
		</div>
	</form>

	<h3 style="text-align: center">Store Details</h3>

	<table align="center">
		<tr>
			<th width="30%">Name</th>
			<td width="2%">:</td>
			<td><c:out value="${store.getName()}" /></td>
		</tr>

		<tr>
			<th width="30%">Mobile Number</th>
			<td width="2%">:</td>
			<td><c:out value="${store.getPhone()}" /></td>
		</tr>

		<tr>
			<th width="30%">Localities</th>
			<td width="2%">:</td>
			<td><c:out value="${store.getLocalities()}" /></td>
		</tr>
		<tr>
			<th width="30%">Email</th>
			<td width="2%">:</td>
			<td><c:out value="${store.getEmail()}" /></td>
		</tr>

		<tr>
			<th width="30%">User Name</th>
			<td width="2%">:</td>
			<td>${store.getUserName()}</td>
		</tr>
	</table>



</body>
</html>