<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
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
	<br>
	<div align="center">
	<samp align="center" style="color:blue"><i> Welcome to Employee Registration Panel</i></samp>
		<form action="add" method="post">
			<table>
				<tr>
					<td>*Name:</td>
					<td><input type="text" name="empName"
						placeholder="Vijay Dinanath Chwohan" required></td>
				</tr>
				<tr>
					<td>*Gender:</td>
					<td><input type="radio" name="empGender" value="male" required>
						Male <input type="radio" name="empGender" value="female" required>
						Female</td>
				</tr>
				<tr>
					<td>*Email Id:</td>
					<td><input type="text" name="empEmail"
						placeholder="dcvijay@gmail.com" required></td>
				</tr>
				<tr>
					<td>*Mobile No:</td>
					<td><input type="text" name="empMobNo"
						placeholder="8875808080" required></td>
				</tr>
				<tr>
					<td>*Date of Birth:</td>
					<td><input style="width: 155px" type="date" name="empDOB" required></td>
				</tr>
				<tr>
					<td>*Date of Joining:</td>
					<td><input style="width: 155px" type="date" name="empDOJ" required></td>
				</tr>
				<tr>
					<td>*Address:</td>
					<td><input style="width: 155px; height: 50px;" type="text" name="empAddress"
						placeholder="Karve Nagar, Pune" required></td>
				</tr>
				<tr>
					<td>*Password:</td>
					<td><input type="password" name="empPass" placeholder="A123@vdc" required></td>
				</tr>
				<tr>
					<td>*Confirm Password:</td>
					<td><input type="password" name="empCfrmPass" placeholder="A123@vdc" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center" style="width: 500px; height: 100px"></div>
</body>
</html>