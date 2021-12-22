<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expiry</title>
</head>
<body>
<h1>Session expired! Inactive for a long time!</h1>
<jsp:include page="login.jsp">
    <jsp:param name="jsessionid" value="<%=session.getId() %>" />
</jsp:include>
</body>
</html>