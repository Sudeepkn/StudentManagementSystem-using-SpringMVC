<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.techpalle.model.Student"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display page</title>
</head>
<body>
	<h2>All Student Details</h2>
	<table border="1" cellspacing="0px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password></th>
			<th>phone no</th>
			<th>Action</th>
		</tr>
		<%
		ArrayList<Student> al = (ArrayList<Student>) request.getAttribute("stud");
		for (Student item : al) {
		%>
		<tr>
			<td><%=item.getId()%></td>
			<td><%=item.getName()%></td>
			<td><%=item.getEmail()%></td>
			<td><%=item.getPassword()%></td>
			<td><%=item.getMobile()%></td>
			<td>
			    <a href="edit?id=<%=item.getId()%>">Edit</a> 
			    <a href="delete?id=<%=item.getId()%>">Delete</a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>