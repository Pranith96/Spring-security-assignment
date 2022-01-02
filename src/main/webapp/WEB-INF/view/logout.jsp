<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<marquee width="100%" behavior="scroll" bgcolor="#00ffff">
	Know Your Neighborhood Application </marquee>
<title>Login success form</title>
<body>
	<%
	request.getSession().invalidate();
	%>
	<h4>Successfully Logout</h4>
	<a href="http://localhost:1210/store/login/page"><b>Click here
			to Login</b></a>
</body>
</html>