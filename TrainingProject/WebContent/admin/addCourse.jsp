<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Course</title>
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

		<h1>Add Course For Users</h1>
		<br>

		<form action="<%=request.getContextPath()%>/admin/course"
			method="post">

			<table style="with: 80%" align="center">
				<tr>
					<td>Course Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Course Description</td>
					<td><input type="text" name="desp" /></td>
				</tr>
				<tr>
					<td>Course Fees</td>
					<td><input type="text" name="fees" /></td>
				</tr>
				<tr>
					<td>Course Resource</td>
					<td><input type="text" name="resource" /></td>
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