<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login.do;jsessionid=<%=session.getId() %>" method="post">
  <input type="hidden" name="formid" value="login">
    UserName:<input type="text" name="uname">
    PassWord:<input type="password" name="upass">
  <input type="submit" value="login"> 
</form>
</body>
</html>