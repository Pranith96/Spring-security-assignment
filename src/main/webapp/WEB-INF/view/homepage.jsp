<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.springbootmvc.a4.entity.Store"%>


<html>

<head>
<title>Know your NeighbourHood</title>

<style>
* {
	margin: 0;
	padding: 0;
}

.navbar {
	display: flex;
	align-items: center;
	justify-content: center;
	position: sticky;
	top: 0;
	cursor: pointer;
}

.background {
	background: black;
	background-blend-mode: darken;
	background-size: cover;
}

.nav-list {
	width: 70%;
	display: flex;
	align-items: center;
}

.nav-list li {
	list-style: none;
	padding: 26px 30px;
}

.nav-list li a {
	text-decoration: none;
	color: white;
}

.nav-list li a:hover {
	color: grey;
}

.rightnav {
	width: 30%;
	text-align: right;
}

#search {
	padding: 5px;
	font-size: 17px;
	border: 2px solid grey;
	border-radius: 9px;
}

.box-main {
	display: flex;
	justify-content: center;
	align-items: center;
	color: black;
	max-width: 80%;
	margin: auto;
	height: 605px;
}

.firsthalf {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.heading-mission {
	font-family: 'Piazzolla', serif;
	font-weight: bold;
	font-size: 35px;
}

.text-mission {
	font-size: 18px;
	padding-bottom: 100px;
}

.heading-vission {
	font-family: 'Piazzolla', serif;
	font-weight: bold;
	font-size: 35px;
}

.text-vision {
	font-size: 18px;
}

.btn {
	padding: 8px 20px;
	margin: 7px 0;
	border: 2px solid white;
	border-radius: 8px;
	background: none;
	color: white;
	cursor: pointer;
}

.btn-sm {
	padding: 6px 10px;
	vertical-align: middle;
}

.text-footer {
	text-align: center;
	padding: 30px 0;
	font-family: 'Ubuntu', sans-serif;
	display: flex;
	justify-content: center;
	color: white;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //HTTP1.1 browser
	response.setHeader("Pragma", "no-cache"); //HTTP1.0 browser
	response.setHeader("Expires", "0"); //proxies
	%>
	<nav class="navbar background">
		<ul class="nav-list">
			<li><a href="http://localhost:1210/store/details/page">Add
					Store</a></li>
			<li><a href="http://localhost:1210/store/logout">Logout</a></li>
		</ul>
		<div class="rightNav">
			<form:form modelAttribute="store" action="../../store/get/email"
				method="get">
				<input type="text" name="email">
				<button class="btn btn-sm">Search</button>
			</form:form>
		</div>
	</nav>
	<div class="box-main">
		<table align="center" border="1" width="50%"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Mobile Number</th>
					<th>Localities</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="store" items="${response}">
					<tr>
						<td><c:out value="${store.getUserId()}" /></td>
						<td><c:out value="${store.getName()}" /></td>
						<td><c:out value="${store.getPhone()}" /></td>
						<td><c:out value="${store.getLocalities()}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer class="background">
		<p class="text-footer">Copyright ©-All rights are reserved</p>
	</footer>
</body>
</html>

