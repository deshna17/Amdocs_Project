<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Portal</title>
<style>
h1 {text-align: center;}
p {text-align: center;}
div {text-align: center;}
body{background-color:#808000}
</style>
</head>
<body>

<div>	
	<h1>Welcome to the Admin Portal</h1>
	<h3>Your Admin Id is : ${message}</h3> 
</div>
<br><br>
<div>
	<a href="admin/user">View Users</a>&emsp;
	<a href="admin/course">Add Courses</a>&emsp;
	<a href="admin/view-course">View Courses</a>&emsp;
	<a href="admin/add">Add Admin</a>&emsp;
	<a href="admin/admin">View Admin</a>&emsp;
	<a href="admin/feedback">View Feedback</a><br><br>&emsp;	
</div>
<div>
	<a href="/TrainingProject/logout">Log Out</a><br><br>&emsp;	
</div>	
</body>
</html>