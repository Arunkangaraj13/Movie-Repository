<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
</head>
<body>
		 <form action="adminlogin" method="post">
		 	<label for="adminEmail">Email Login Email</label>
		 	<input type="text" name="adminemail" id="adminEmail">
		 	<label for="adminPwd">Login Password</label>
		 	<input type="text" name="adminpwd">
		 	<input type="submit">
		 	
		 	<%String loginMessage= (String)request.getAttribute("signupmessage");%>
		 	<%if(loginMessage !=null){%>
		 	<%=loginMessage %>
		 	<%} %>
		 	
		 	
		 	
		 </form>
</body>
</html>