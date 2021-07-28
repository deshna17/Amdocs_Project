<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Portal</title>
<style>
h1 {text-align: center;}
p {text-align: center;}
div {text-align: center;}
body{background-color:#808000 }
</style>
</head>
<body>

<div>	
	<h1>Welcome to the User Portal</h1>
	<h3>Your User Id is : ${message}</h3> 
</div>
<br><br>
<div>
	<a href="user/view-course">My Courses</a>&emsp;
	<a href="user/add-course">Enroll Courses</a>&emsp;
	<a href="user/admin">View Admin</a>&emsp;
	<a href="user/feedback">Feedback</a><br><br>&emsp;	
</div>

<div>
	<a href="/TrainingProject/logout">Log Out</a><br><br>&emsp;	
</div>
	
</body>
</html>