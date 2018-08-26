<%@page import="com.emp.model.admin.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin home</title>

<script type="text/javascript">

	function getCheckedCheckboxesFor(checkboxName) {
		var checkboxes = document.querySelectorAll('input[name="' + checkboxName + '"]:checked'), values = [];
		Array.prototype.forEach.call(checkboxes, function(el) {
			values.push(el.value);
		});
		return values.join('n');
	}


	function setDeleteUrl() {
		var elem = document.getElementById("delete");
		elem.href = "/EmployeeManagement/delete?ids="
				+ getCheckedCheckboxesFor('employee');
	}
	
	function setUpdateUrl() {
		var elem = document.getElementById("update");
		elem.href = "/EmployeeManagement/update?id="
				+ getCheckedCheckboxesFor('employee');
	}
		
	function selectAll(source) {
			checkboxes = document.getElementsByName("employee");
			for ( var i in checkboxes)
				checkboxes[i].checked = source.checked;
	}
</script>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		//response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		//response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		Object user = session.getAttribute("user"); 
			if ( user == null | !(user instanceof Admin)) {
				System.out.println("Admin: in if of jsp");
				request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
			}else{
				System.out.println("Admin: in else of jsp");
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

		<br> <br>
		<div align="center">
			<h1 style="color: green">Employee Management</h1>
			<h2 style="color: red">
				<a href="/EmployeeManagement/registration?who=admin">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="" onclick="setUpdateUrl();" id="update">Update</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="" onclick="setDeleteUrl();" id="delete">Delete</a>
			</h2>
			<table border="1" cellpadding="10">
				<caption>
					<h2>
						<a href="/EmployeeManagement/admin/show">List of All Employee</a>
					</h2>
				</caption>
				<th><input type="checkbox" id="selectall" onClick="selectAll(this);" /></th>
				<th><a href="/EmployeeManagement/admin/sort?by=id">ID</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=name">Name</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=gender">Gender</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=email">Email</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=mobile">Mobile</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=address">Address</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=dob">Birth Date</a></th>
				<th><a href="/EmployeeManagement/admin/sort?by=doj">Joining Date</a></th>
				<c:forEach var="emp" items="${listEmp}">
					<tr>
						<td><input name="employee" type="checkbox" value="${emp.id}" /></td>
						<td><c:out value="${emp.id}" /></td>
						<td><c:out value="${emp.name}" /></td>
						<td><c:out value="${emp.gender}" /></td>
						<td><c:out value="${emp.email}" /></td>
						<td><c:out value="${emp.mobNo}" /></td>
						<td><c:out value="${emp.address}" /></td>
						<td><c:out value="${emp.dob}" /></td>
						<td><c:out value="${emp.joinDate}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<% } %>
</body>
</html>