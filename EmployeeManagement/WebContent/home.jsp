<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
</head>
<body>
	<%
	    response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		if (session.getAttribute("user_name") == null){
			response.sendRedirect("login.jsp");
		}
		String name =session.getAttribute("user_name").toString();
	%>
	<div align="Center">
		<i style="color: green"><%=name%> You are successfully logged
			in...</i><br> <br>
		<form action="list">
			<input type="submit" value="Show Records" />
		</form>
		<br>
		<form action="add">
			<input type="submit" value="Add Records" />

		</form>
		<br>
		<form action="delete">
			<input type="submit" value="Delete Record" />

		</form>
		<br>
		<form action="update">
			<input type="submit" value="Update Record" />

		</form>
		<br> <br>
		<form action="logout">
			<input type="submit" value="Logout" />
		</form>
	</div>
</body>
</html>