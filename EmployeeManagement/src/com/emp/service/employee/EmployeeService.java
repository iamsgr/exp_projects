package com.emp.service.employee;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.employee.ManipulateEmployee;

public class EmployeeService {

	public static void loginEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = request.getParameter("user_name").trim();
		String pass = request.getParameter("password");

		boolean dbpass = ManipulateEmployee.getCredentials(uname, pass);

		if (uname.equals("") || pass.equals("")) {
			request.getRequestDispatcher("/error_pages/bothfields.jsp").include(request, response);
			request.getRequestDispatcher("login.jsp").include(request, response);
		} else if (dbpass) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user_name", uname);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/error_pages/error.jsp").include(request, response);
			request.getRequestDispatcher("login.jsp").include(request, response);

		}

	}

	public static void logoutEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("user_name") != null) {
			session.removeAttribute("user_name");
			session.invalidate();
			out.println("<html><body>");
			out.print("<div align=\"center\" ><i style=\"color:green\">You are successfully logged out...</i></div>");
			out.println("</body></html>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		} else {
			out.println("<html><body>");
			out.print("<p align=\"center\" style=\"color:red\"> Please login first...</p>");
			out.println("</body></html>");
			request.getRequestDispatcher("login.jsp").include(request, response);

		}

		out.close();
	}
}
