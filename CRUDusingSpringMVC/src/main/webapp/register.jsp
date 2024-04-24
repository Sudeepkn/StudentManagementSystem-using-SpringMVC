<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.techpalle.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
	<%
	Student s = (Student) request.getAttribute("student");
	if (s == null) {
	%>
	<h2>Student Registration</h2>
	<form action="reg" method="post">
		<div hidden>
			<input type="number" name="tbId">
		</div>

		Name : <input type="text" name="tbName"><br> Email : <input
			type="email" name="tbEmail"><br> Password : <input
			type="password" name="tbPwd"><br> Mobile : <input
			type="tel" name="tbMobile"><br> <input type="submit"
			name="tbSmt">
	</form>
	<%
	}
	if (s != null) {
	%>
	<h2>Student Edit Form</h2>
	<form action="update" method="post">
		<div hidden>
			<input type="number" name="tbId" value="<%=s.getId()%>">
		</div>

		Name : <input type="text" name="tbName" value="<%=s.getName()%>"><br>
		Email : <input type="email" name="tbEmail" value="<%=s.getEmail()%>"><br>
		Password : <input type="password" name="tbPwd"
			value="<%=s.getPassword()%>"><br> Mobile : <input
			type="tel" name="tbMobile" value="<%=s.getMobile()%>"><br>

		<input type="submit" name="tbSmt">
	</form>
	<%
	}
	%>

	<%
	if (request.getAttribute("res") != null) {
	%>
	<h2>Student added successfully</h2>
	<%
	}
	%>
</body>
</html>