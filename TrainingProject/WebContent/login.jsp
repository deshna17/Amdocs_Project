<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
h1 {text-align: center;}
p {text-align: center;}
table {text-align: center;}
body{background-color:#808000}
</style>
</head>
<body>

 <div align="center">
  <h1>Login</h1><br>
  <form action="<%= request.getContextPath() %>/login" method="post">
   <table style="with: 80%">
    <tr>
     <td>User Id</td>
     <td><input type="text" name="loginid" /><br><br></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
   </table>
   <br><br>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>