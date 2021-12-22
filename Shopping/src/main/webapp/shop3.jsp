<%@ page import="java.util.TreeSet" %>
<%@ page import="exercise.item.ItemDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shop1</title>
</head>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>
<h1>Groceries Shop</h1>
<form method="get" action="shopping.do;jsessionid=<%=session.getId() %>">
  <input type="hidden" name="formid" value="shopping">
  <input type="hidden" name="shopid" value="shop3">
<table style="width:100%">
  <tr>
    <th>Item No</th>
    <th>Item Name</th>
    <th>Unit</th>
    <th>Unit Price</th>
    <th>Image</th>
    <th>Select</th>
  </tr>
<%TreeSet<ItemDTO> gro = (TreeSet<ItemDTO>)session.getAttribute("groceries"); 
    for(ItemDTO g:gro){%>
      <tr>
        <td><%=g.getItemno() %></td>
        <td><%=g.getItemname()%></td>
        <td><%=g.getUnit()%></td>
        <td><%=g.getUnitprice()%></td>
        <td align="center"><img src="<%=g.getImg()%>" width="75" height="70" /></td>
        <td><input type="checkbox" value=<%=g.getUnitprice()%> name=<%=g.getItemno()%>></td>
      </tr>
    <%}%>
</table>
<input type="submit" value="Next shop"> 
</form>
</body>
</html>