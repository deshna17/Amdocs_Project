<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Registration</title>
<style>
h1 {
	text-align: center;
}

p {
	text-align: center;
}

div {
	text-align: center;
}

table {
	text-align: center;
}

body {
	background-color: #F5E79D
}
</style>
</head>
<body>
	<div align="center">
		<h1>Admin Registeration Form</h1>
		<form action="<%=request.getContextPath()%>/admin/add" method="post"
			align="center">

			<table style="with: 80%" align="center">
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="Submit" />
		</form>
	</div>
	<br>
	<div>
		<a href="/FinalProject/admin">Home</a>&emsp; <a
			href="/FinalProject/logout">Log Out</a>&emsp;
	</div>
</body>
</html>