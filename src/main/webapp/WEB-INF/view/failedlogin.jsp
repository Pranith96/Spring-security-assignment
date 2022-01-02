<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html"%>

<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Know Your Neighborhood Application</marquee>
<body bgcolor="#87ceff">
	<script>
		function validateform() {
			var userName = document.myform.userName.value;
			var password = document.myform.password.value;

			if (userName == "") {
				alert("userName is Mandatory");
				return false;
			}

			if (password == "") {
				alert("Password is Mandatory");
				return false;
			}

		}
	</script>

	<h1>Login</h1>
	<h3>${response}</h3>
	<form:form modelAttribute="user"
		action="../../store/login/check" method="post"
		onsubmit="return validateform()">
		<table>
			<tr>
				<td><label class="label">User Name:</label></td>
				<td><form:input path="userName"></form:input></td>
			</tr>
			<tr>
				<td><label class="label">Password</label></td>
				<td><form:input type="password" path="password"></form:input></td>
			</tr>
			<tr>
				<td><input type="submit" value="submit" /></td>
			</tr>
			<tr>
				<td><input type="reset" style="float: right"></input></td>
			</tr>
		</table>
	</form:form>

</body>
</html>