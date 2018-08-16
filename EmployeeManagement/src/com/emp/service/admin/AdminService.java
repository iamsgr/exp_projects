package com.emp.service.admin;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.admin.ManipulateAdmin;
import com.emp.dao.employee.ManipulateEmployee;
import com.emp.model.employee.Employee;
import com.emp.utiities.comparator.AddressComparator;
import com.emp.utiities.comparator.DOBComparator;
import com.emp.utiities.comparator.DOJComparator;
import com.emp.utiities.comparator.GenderComparator;
import com.emp.utiities.comparator.IDComparator;
import com.emp.utiities.comparator.MobileComparator;

public class AdminService {
	
	public static List<Employee> listEmp = null;
	
	public static void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = null;
		String pass = null;
		uname = request.getParameter("admin_name");
		pass = request.getParameter("admin_pass");
		boolean dbpass = false;
		if (uname != null | pass != null) {
			if (uname.equals("") || pass.equals("")) {
				request.getRequestDispatcher("/error_pages/bothfields.jsp").include(request, response);
				request.getRequestDispatcher("adminLogin.jsp").include(request, response);
			} else {
				dbpass = ManipulateAdmin.getAdminCredentials(uname.trim(), pass.trim());
				if (dbpass) {
					HttpSession session = request.getSession(true);
					session.setAttribute("admin_name", uname);
					session.setAttribute("ID", "ADMIN");
					listEmp=null;
					listEmp(request, response);
				} else {
					request.getRequestDispatcher("/error_pages/error.jsp").include(request, response);
					request.getRequestDispatcher("adminLogin.jsp").include(request, response);
				}
			}
		} else {
			listEmp(request, response);
		}
	}

	public static void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("admin_name");
			session.removeAttribute("ID");
			session.invalidate();
			out.println("<html><body>");
			out.print("<div align=\"center\" ><i style=\"color:green\">You are successfully logged out...</i></div>");
			out.println("</body></html>");
			request.getRequestDispatcher("adminLogin.jsp").include(request, response);
		} else {
			out.println("<html><body>");
			out.print("<p align=\"center\" style=\"color:red\"> Please login first...</p>");
			out.println("</body></html>");
			request.getRequestDispatcher("adminLogin.jsp").include(request, response);

		}

		out.close();
	}
	
	public static void listEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (listEmp == null)
			listEmp = (List<Employee>) ManipulateEmployee.getAllEmployee();
		request.setAttribute("listEmp", listEmp);
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	}

	public static void sortEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String para = null;
		para = request.getParameter("by");
		System.out.println("Before sorting##" + para + "##");
		if (para != null) {
			if (!para.equals("")) {
				String sortBy = para.trim();
				System.out.println("After Sorting##" + sortBy + "##");
				switch (sortBy) {
				case "id":
					Collections.sort(listEmp, IDComparator.getInstance());
					listEmp(request, response);
					break;
				case "name":
					Collections.sort(listEmp, MobileComparator.getInstance());
					listEmp(request, response);
					break;
				case "gender":
					Collections.sort(listEmp, GenderComparator.getInstance());
					listEmp(request, response);
					break;
				case "email":
					Collections.sort(listEmp, DOJComparator.getInstance());
					listEmp(request, response);
					break;
				case "address":
					Collections.sort(listEmp, AddressComparator.getInstance());
					listEmp(request, response);
					break;
				case "dob":
					Collections.sort(listEmp, DOBComparator.getInstance());
					listEmp(request, response);
					break;
				case "doj":
					Collections.sort(listEmp, DOJComparator.getInstance());
					listEmp(request, response);
					break;
				case "mobile":
					Collections.sort(listEmp, MobileComparator.getInstance());
					listEmp(request, response);
					break;
				default:
					Collections.sort(listEmp, IDComparator.getInstance());
					listEmp(request, response);
					break;
				}
			} else {
				listEmp(request, response);
			}
		} else {
			listEmp(request, response);
		}

	}

}
