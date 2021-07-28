<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<style>
h1 {text-align: center;}
p {text-align: center;}
table {text-align: center;}
body{background-color:#808000}
</style>
</head>
<body>

 <div align="center">
  <h1>User Registeration Form</h1><br>
  <form action="<%= request.getContextPath() %>/user-register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Phone No</td>
     <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Upload Photo</td>
     <td><input type="text" name="photo" /></td>
    </tr>
   </table>
   <br><br>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>