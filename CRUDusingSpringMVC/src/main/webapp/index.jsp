<html>
<head>
<title>Admin Login</title>
</head>
<body>
<h2>Enter your credential to login</h2>
<form action="login" method="post">
Email : <input type="email" name="tbEmail"><br>
Password : <input type="password" name="tbPwd"><br>
<input type="submit" value="login">
<% String s = (String)request.getAttribute("invalid"); 
if(s!=null){
%>
<h3>Either Email or Password is incorrect</h3>
<%} %>

</form>
</body>
</html>
