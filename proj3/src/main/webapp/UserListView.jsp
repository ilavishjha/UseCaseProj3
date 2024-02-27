<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="proj3.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%UserDTO dto=new UserDTO(); 
List list=(List)request.getAttribute("List");
Iterator<UserDTO> it=list.iterator();

%>
<form action="UserListCtl" method="post">

<table>
<tr ><td><input type="text" name="name" ></td>

<td>
<input type="submit" name="operation" value="search">
</td>
</tr>
</table>
<table border="1"   >
<tr >
<th>Select</th>
<th>ID</th>
<th>Name</th>
<th>Address</th>
<th>Edit</th>
</tr>


<%while(it.hasNext()){ 
dto=(UserDTO)it.next();
%>


<tr>
<td><input type="checkbox" name="ids" value="<%=dto.getId() %>"></td>
<td><%=dto.getId() %></td>
<td><%=dto.getName() %></td>
<td><%=dto.getAddress() %></td>
<td><a href="UserCtl?id=<%=dto.getId()%>">edit</a></td>

<%} %>
</tr>

</table>
<table>
<tr>
<td>
<input type="submit" name="operation" value="delete">
</td>

</tr>
</table>
</form>
</body>
</html>