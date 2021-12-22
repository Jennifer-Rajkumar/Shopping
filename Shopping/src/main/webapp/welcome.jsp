<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
<h1 id="uname">Welcome!</h1>

<jsp:include page="logout.jsp">
    <jsp:param name="jsessionid" value="<%=session.getId() %>" />
</jsp:include>

<form method="get" action="shopping.do;jsessionid=<%=session.getId() %>">
  <input type="hidden" name="formid" value="goshopping">
  <input type="submit" value="Go shopping">
</form>
</body>
</html>