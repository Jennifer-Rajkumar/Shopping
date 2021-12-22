<%@ page import="java.util.Enumeration" %>
<%@ page import="exercise.item.ItemDAOImpl" %>
<%@ page import="exercise.item.ItemDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <%
    int total=0;
    Enumeration e = session.getAttributeNames();
	while(e.hasMoreElements()) {
		String name=(String)e.nextElement();
		if(!name.equals("vegetable") && !name.equals("fruit") && !name.equals("groceries") && !name.equals("name") && !name.equals("shopid") && !name.equals("formid")) {
		    String value=(String)session.getAttribute(name);
		    ItemDAOImpl obj = new ItemDAOImpl();
		    ItemDTO itemDTO = obj.getItem(Integer.parseInt(name));
		    out.println("<h1>"+itemDTO.getItemname()+":"+value+"</h1>");
		    total+=Integer.parseInt(value);
		}
	}
	session.setAttribute("total", Integer.toString(total));
	out.println("<h1>Total: "+total+"</>");
  %>
  <form action="invoice.do;jsessionid=<%=session.getId() %>" method="post">
    <input type="hidden" name="formid" value="invoice">
      Address:<input type="text" name="address">
      Phone Number:<input type="text" name="phone">
    <input type="submit" value="Order"> 
  </form>
</body>
</html>