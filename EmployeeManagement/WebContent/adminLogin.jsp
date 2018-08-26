<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin login</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<div align="center">
		<a href="/EmployeeManagement/adminLogin.jsp">Admin</a> <span><label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label></span><span><a
			href="/EmployeeManagement/registration.jsp">Registration</a></span><span><label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label></span><a
			href="/EmployeeManagement/login.jsp">Login</a><span></span>
	</div>
	</div>
	<br>
	<div align="center">
	    <samp align="center" style="color:blue"><i> Welcome to the Admin Login Panel</i></samp>
		<form action="login" method="post">
			<table>
				<tr>
					<td>Admin Name:</td>
					<td><input type="text" name="admin_name" placeholder="Admin_Name" required ></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="admin_pass" placeholder="Admin_Password" required></td>
				</tr>
				<tr>
					<td></td>
					<td><button style="width: 70px; height: 20px;">Login</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
