<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
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
		<h1>User Feedback Form</h1>
		<br>
		<form action="<%=request.getContextPath()%>/user/feedback"
			method="post">
			<textarea rows="4" cols="50" name="feedback_message">
	Enter Your Feedback Here...</textarea>
			<br>
			<br> <input type="submit" value="Submit" />
		</form>
	</div>
	<br><br>
	<div>
		<a href="/FinalProject/user">Home</a>&emsp; <a
			href="/FinalProject/logout">Log Out</a>&emsp;
	</div>
</body>
</html>