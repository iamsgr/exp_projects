<%@page import="com.emp.model.admin.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update</title>
</head>
<body>
	<%
		 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		 	//response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		  	//response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
			response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
			response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
			Object user = session.getAttribute("user"); 
			if ( user == null & !(user instanceof Admin)) {
				System.out.println("in if of jsp");
				response.sendRedirect("adminLogin.jsp");
			}else{
				System.out.println("in else of jsp");
				Admin admin = (Admin)session.getAttribute("user");
	

	%>

	<div align="Center">
		<table style="width:-webkit-fill-available">
			<tr>
				<td><div>
                      <a href="/EmployeeManagement/admin/adminHome" style="float:left">Home</a>
					</div>
			    </td>

				<td><div>
						<span style="float:right"><i style="color: green ; float:right">Welcome <%=admin.getName()%>
						</i></span> <br> 
						<span style="float:right">
							<a href="/EmployeeManagement/logout" style="float:right">logout</a>
						</span>
					</div>
				</td>
			</tr>
		</table>


		<form action="save" method="post">
			<table border="1" cellpadding="12">
				<caption>
					<h2>
						<c:if test="${emp != null}">
                        Edit Employee
                    </c:if>
					</h2>
				</caption>
				<tr>
					<th>ID:</th>
					<td><input type="text" value="${emp.id}" name="empID"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<th>Name:</th>
					<td><input type="text" value="${emp.name}" name="empName" required /></td>
				</tr>
				<tr>
					<th>Gender:</th>
					<td><input type="text" value="${emp.gender}" name="empGender" required /></td>
				</tr>
				<tr>
					<th>Email:</th>
					<td><input type="text" value="${emp.email}" name="empEmail" required /></td>
				</tr>
				<tr>
					<th>Mobile:</th>
					<td><input type="text" value="${emp.mobNo}" name="empMob" required /></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" value="${emp.address}" name="empAddress" required /></td>
				</tr>
				<tr>
					<th>Birth Date:</th>
					<td><input type="text" value="${emp.dob}" name="empDOB" required /></td>
				</tr>
				<tr>
					<th>Joining Date:</th>
					<td><input type="text" value="${emp.joinDate}" name="empDOJ" required /></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" value="${emp.password}" name="empPass" required /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save" /></td>
				</tr>
			</table>
		</form>
	</div>
	<%} %>
</body>
</html>