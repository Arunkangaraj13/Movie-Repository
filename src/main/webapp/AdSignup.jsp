<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Signup</title>
</head>
<body>
	<h1>AdminSignup</h1>
	
	
	<form action="adminsignup" method="post">
	Enter Your Id::<input type="text" name="adminId"><br><br>
	Enter Your Name::<input type="text" name="adminName"><br><br>
	Enter Your Phone::<input type="text" name="adminPhone"><br><br>
	Enter Your email::<input type="text" name="adminEmail"><br><br>
	Enter Your Password::<input type="text" name="adminPwd"><br><br>
	<input type="submit">
	</form>
	
	<%String signupMessage=(String) request.getAttribute("signupmessage"); %>
	<% if(signupMessage!=null){ %>
	<%=signupMessage %>
	<%} %>


	
</body>
</html>