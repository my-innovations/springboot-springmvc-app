<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
<link href="webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.errormsg {
	color: red;
}
</style>
</head>
<body>
	<h1>Edit User</h1>
	<form:form method="POST"
		action="${pageContext.request.contextPath}/editsave"
		modelAttribute="user">
		
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="errormsg" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="errormsg" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="errormsg" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" /></td>
				<td><form:errors path="dob" cssClass="errormsg" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
			
		</table>
	
	</form:form>
	<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.2.1/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>