<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="login.do" method="post">

  <input type="hidden" name="formid" value="register">
    UserID:<input type="text" name="uid">
    UserName:<input type="text" name="uname">
    PassWord:<input type="password" name="upass">
    Amount:<input type="text" name="amt">
  <%@ include file="create.jsp" %>
</form>
</body>
</html>