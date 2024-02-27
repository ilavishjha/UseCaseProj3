<%@page import="proj3.UserDTO"%>
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
	<h2>
		<a href="UserListCtl">Back</a>
	</h2>
	<%
		UserDTO dto = (UserDTO) request.getAttribute("dto");
	String msg=(String)request.getAttribute("msg");
	%>
	<form action="UserCtl" method="post">
		<center>
			<%
				if (dto != null) {
			%>
			<h1>Edit User</h1>
			<%
				} else {
			%>
			<h1>Add User</h1>
			<%
				}
			%>
			<%
			if(msg!=null){%>
<%=msg %>
<%} %>


			<table>
				<input type="hidden" name="id"
					value="<%=(dto != null) ? dto.getId() : ""%>">
				<tr>
					<th>Name:</th>
					<td><input type="text" name="name"
						value="<%=(dto != null) ? dto.getName() : ""%>"></td>
				</tr>


				<tr>
					<th>Address :</th>
					<td><input type="text" name="address"
						value="<%=(dto != null) ? dto.getAddress() : ""%>"></td>
				</tr>
			</table>
			<table>
				<%
					if (dto != null) {
				%>
				<tr>
					<td><input type="submit" name="operation" value="update"></td>
                    <td><input type="submit" name="operation" value="AddUser"></td>

				</tr>
				<%
					} else {
				%>
				<tr>
					<td><input type="submit" name="operation" value="save"></td>
					 <td><input type="submit" name="operation" value="cancel"></td>	
				</tr>
				<%
					}
				%>
			</table>
		</center>
	</form>
</body>
</html>