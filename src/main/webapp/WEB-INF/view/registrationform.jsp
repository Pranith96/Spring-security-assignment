<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<title>ADD Store details</title>
</head>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var name = document.myform.name.value;
			var phone = document.myform.phone.value;
			var localities = document.myform.localities.value;
			var email = document.myform.email.value;
			var userName = document.myform.userName.value;
			var password = document.myform.password.value;

			if (name == "") {
				alert("Name is Mandatory");
				return false;
			}

			if (phone == "") {
				alert("Mobile Number is Mandatory");
				return false;
			}

			if (localities == "") {
				alert("localities is Mandatory");
				return false;
			}

			if (email == "") {
				alert("Email is Mandatory");
				return false;
			}

			if (password == "") {
				alert("password is Mandatory");
				return false;
			}
		}
	</script>

	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //HTTP1.1 browser
	response.setHeader("Pragma", "no-cache"); //HTTP1.0 browser
	response.setHeader("Expires", "0"); //proxies
	%>
	
	<h1 style="text-align: left;">Store Registration Form</h1>
	<form align='left' action='http://localhost:1210/store/login/page'>
		<div align='left'>
			<input type='submit' value='Login' />
		</div>
	</form>
	<table align="left">
		<form:form modelAttribute="store" name="myform"
			action="../../store/registration/save" method="post"
			onsubmit="return validateform()">

			<tr>
				<td><label>Name:</label></td>
				<td><form:input path="name"></form:input></td>
			</tr>

			<tr>
				<td><label>Mobile Number:</label></td>
				<td><form:input path="phone"></form:input></td>
			</tr>

			<tr>
				<td><label>Localities:</label></td>
				<td><form:input path="localities"></form:input></td>
			</tr>

			<tr>
				<td><label>Email:</label></td>
				<td><form:input path="email"></form:input></td>
			</tr>

			<tr>
				<td><form:label path="role"> User Role: </form:label></td>
				<td><form:checkbox path="role" value="ROLE_USER" label="USER" />
					<form:checkbox path="role" value="ROLE_ADMIN" label="ADMIN" /> <form:checkbox
						path="role" value="ROLE_MODERATOR" label="MODERATOR" /></td>
			</tr>

			<tr>
				<td><label>User Name:</label></td>
				<td><form:input path="userName"></form:input></td>
			</tr>

			<tr>
				<td><label>Password:</label></td>
				<td><form:input type="password" path="password"></form:input></td>
			</tr>

			<tr>
				<td><input type="submit" style="float: right"></input></td>
			</tr>
			<tr>
				<td><input type="reset" style="float: right"></input></td>
			</tr>
		</form:form>
	</table>


</body>
</html>