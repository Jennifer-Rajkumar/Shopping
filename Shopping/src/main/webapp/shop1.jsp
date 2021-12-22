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
<h1>Vegetable Shop</h1>
<form method="get" action="shopping.do;jsessionid=<%=session.getId() %>">
  <input type="hidden" name="formid" value="shopping">
  <input type="hidden" name="shopid" value="shop1">
<table style="width:100%">
  <tr>
    <th>Item No</th>
    <th>Item Name</th>
    <th>Unit</th>
    <th>Unit Price</th>
    <th>Image</th>
    <th>Select</th>
  </tr>
<%TreeSet<ItemDTO> veg = (TreeSet<ItemDTO>)session.getAttribute("vegetable"); 
    for(ItemDTO v:veg){%>
      <tr>
        <td><%=v.getItemno() %></td>
        <td><%=v.getItemname()%></td>
        <td><%=v.getUnit()%></td>
        <td><%=v.getUnitprice()%></td>
        <td align="center"><img src="<%=v.getImg()%>" width="75" height="70" /></td>
        <td><input type="checkbox" value=<%=v.getUnitprice()%> name=<%=v.getItemno()%>></td>
      </tr>
    <%}%>
</table>
<input type="submit" value="Next shop"> 
</form>
</body>
</html>