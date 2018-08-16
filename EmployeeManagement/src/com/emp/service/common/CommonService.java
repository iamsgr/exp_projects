package com.emp.service.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.employee.ManipulateEmployee;
import com.emp.model.employee.Employee;
import com.emp.service.admin.AdminService;

public class CommonService {

	public static void showRegistrationForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String para = request.getParameter("who");
		System.out.println(para);
		if (para != null & para.equals("admin")) {
			System.out.println("in");
			out.println("<html><body>");
			out.print("<p align=\"center\"> <a style=\"float:left\" href=\"/EmployeeManagement/admin/show\">Home</a></p>");
			out.println("</body></html>");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		} else {
			System.out.println("out");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		}

	}

	public static void insertEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		Employee emp = new Employee();

		String name = request.getParameter("empName").trim();
		String gender = request.getParameter("empGender").trim();
		String email = request.getParameter("empEmail").trim();
		String mob = request.getParameter("empMobNo").trim();
		String dob = request.getParameter("empDOB").trim();
		String doj = request.getParameter("empDOJ").trim();
		String address = request.getParameter("empAddress").trim();
		String pass = request.getParameter("empPass").trim();
		String cpass = request.getParameter("empCfrmPass").trim();

		emp.setName(name);
		emp.setGender(gender);
		emp.setEmail(email);
		emp.setMobNo(mob);
		emp.setDob(dob);
		emp.setJoinDate(doj);
		emp.setAddress(address);
		emp.setPassword(pass);

		if (pass.equals(cpass)) {
			ManipulateEmployee.insertEmployee(emp);
			if(request.getSession(false).getAttribute("ID")!= null & request.getSession(false).getAttribute("ID").equals("ADMIN")) {
				AdminService.listEmp = null;
				AdminService.listEmp(request, response);
			}else {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			out.println("<div align=\"center\"><span style=\" color:red\">Password is Not matching...</span></div>");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		}
	}

	public static void updateEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String para = null;
		para = request.getParameter("id");
		System.out.println("Before Update##" + para + "##");
		if (para != null) {
			if (!para.equals("")) {
				String[] str = para.trim().split("n");
				int id = Integer.parseInt(str[0]);
				System.out.println("Emp ID : in int" + id);
				System.out.println("After Update##" + str + "##");
				Employee emp = new Employee();
				emp = ManipulateEmployee.getSingleEmployee(id);
				System.out.println("Emp details which going to sort:" + emp);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			} else {
				AdminService.listEmp(request, response);
			}
		} else {
			AdminService.listEmp(request, response);
		}

	}

	public static void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String para = null;
		para = request.getParameter("ids");
		System.out.println("Before Delete##" + para + "##");
		if (para != null) {
			if (!para.equals("")) {
				String empIds = para.trim().replace("n", ",");
				System.out.println("After Delete##" + empIds + "##");
				ManipulateEmployee.deleteEmployee(empIds);
				AdminService.listEmp = null;
				AdminService.listEmp(request, response);
			} else {
				AdminService.listEmp(request, response);
			}
		} else {
			AdminService.listEmp(request, response);
		}
	}

	public static void saveEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Employee emp = new Employee();

		int id = Integer.parseInt(request.getParameter("empID").trim());
		String name = request.getParameter("empName").trim();
		String gender = request.getParameter("empGender").trim();
		String email = request.getParameter("empEmail").trim();
		String mob = request.getParameter("empMob").trim();
		String dob = request.getParameter("empDOB").trim();
		String doj = request.getParameter("empDOJ").trim();
		String address = request.getParameter("empAddress").trim();
		String pass = request.getParameter("empPass").trim();

		emp.setId(id);
		emp.setName(name);
		emp.setGender(gender);
		emp.setEmail(email);
		emp.setMobNo(mob);
		emp.setDob(dob);
		emp.setJoinDate(doj);
		emp.setAddress(address);
		emp.setPassword(pass);

		boolean res = ManipulateEmployee.updateEmployee(emp);
		if (res) {
			AdminService.listEmp = null;
			AdminService.listEmp(request, response);
		}
		else {
			AdminService.listEmp(request, response);
		}

	}
}
