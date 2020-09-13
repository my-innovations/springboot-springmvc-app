<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->
<link href="webjars/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
.errormsg {
	color: red;
}
</style>
</head>
<body>

<div class="container">
	<h1>
		Add A New User
	</h1>
	<form:form method="post" action="save" modelAttribute="user">
	
	<fieldset class="form-group">
		<form:label path="name">Name</form:label> 
		<form:input path="name" type="text"  class="form-control"/> 
		<form:errors path="name" cssClass="errormsg" /><br/>
		</fieldset>
		<fieldset class="form-group">
		<form:label path="age"> Age</form:label> 
		<form:input type="text"  path="age" class="form-control"/>
		<form:errors path="age" cssClass="errormsg" /><br/>
		</fieldset>
		<fieldset class="form-group">
		<form:label path="email">Email</form:label> 
		<form:input type="text"  path="email" class="form-control" />
		<form:errors path="email" cssClass="errormsg" /><br/>
		</fieldset>
		<fieldset class="form-group">
		<form:label path="dob">DOB</form:label> 
		<form:input type="text"  path="dob" class="form-control"/> 
		<form:errors path="dob" cssClass="errormsg" /><br/>
		</fieldset>
		
		<button type="submit" class="btn btn-success">Save</button>
	

		<%-- 
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" placeholder="Enter Name" /></td>
				<td><form:errors path="name" cssClass="errormsg" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="errormsg" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" placeholder="Enter Email" /></td>
				<td><form:errors path="email" cssClass="errormsg" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	 --%>	
		
	</form:form>
</div>
	
	
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/bootstrap/4.2.1/js/bootstrap/bootstrap.min.js"></script>
</body>
</html>
