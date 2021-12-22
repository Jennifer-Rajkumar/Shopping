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
<h1>Fruit Shop</h1>
<form method="get" action="shopping.do;jsessionid=<%=session.getId() %>">
  <input type="hidden" name="formid" value="shopping">
  <input type="hidden" name="shopid" value="shop2">
<table style="width:100%">
  <tr>
    <th>Item No</th>
    <th>Item Name</th>
    <th>Unit</th>
    <th>Unit Price</th>
    <th>Image</th>
    <th>Select</th>
  </tr>
<%TreeSet<ItemDTO> fru = (TreeSet<ItemDTO>)session.getAttribute("fruit"); 
    for(ItemDTO f:fru){%>
      <tr>
        <td><%=f.getItemno() %></td>
        <td><%=f.getItemname()%></td>
        <td><%=f.getUnit()%></td>
        <td><%=f.getUnitprice()%></td>
        <td align="center"><img src="<%=f.getImg()%>" width="70" height="75" /></td>
        <td><input type="checkbox" value=<%=f.getUnitprice()%> name=<%=f.getItemno()%>></td>
      </tr>
    <%}%>
</table>
<input type="submit" value="Next shop"> 
</form>
</body>
</html>