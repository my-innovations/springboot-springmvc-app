<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
<title>All Users</title>
<link href="webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="http://www.in28minutes.com" class="">ContactApp</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/">Home</a></li>
			<li><a href="/users">All Users</a></li>
		</ul>
	</div>
</nav>

<h1 align="center">Users List</h1>
<a href="register">Add A New User</a>
<div class="container"></div>
<table class="table table-striped">
	<caption>All Users</caption>
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Age</th>
			<th>Email</th>
			<th>Date of Birth</th>
			<th>Edit/Delete</th>
		</tr>
	</thead>
	<tbody>
		<!-- JSTL for loop -->
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
				<td>${user.email}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${user.dob}" /></td>
				<td><a type="button" class="btn btn-warning" href="edit/${user.id}">Edit</a>/<a type="button" class="btn btn-warning"  href="delete/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.2.1/js/bootstrap/bootstrap.min.js"></script>

</body>
</html>
