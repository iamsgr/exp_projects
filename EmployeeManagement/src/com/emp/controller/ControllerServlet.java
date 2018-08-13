package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.dao.ManipulateEmp;
import com.emp.model.Employee;
import com.emp.utiities.comparator.AddressComparator;
import com.emp.utiities.comparator.DOBComparator;
import com.emp.utiities.comparator.DOJComparator;
import com.emp.utiities.comparator.GenderComparator;
import com.emp.utiities.comparator.IDComparator;
import com.emp.utiities.comparator.MobileComparator;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static List<Employee> listEmp = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/adminHome":
				if(request.getSession(false).getAttribute("admin_name") == null)
					request.getRequestDispatcher("login.jsp").include(request, response);
				else
				    listEmp(request, response);
				break;
			case "/login":
				loginEmp(request, response);
				break;
			case "/adminLogin":
				loginAdmin(request, response);
				break;
			case "/logout":
				logoutEmp(request, response);
				break;
			case "/adminLogout":
				logoutAdmin(request, response);
				break;
			case "/registration":
				showRegistrationForm(request, response);
				break;
			case "/add":
				insertEmp(request, response);
				break;
			case "/delete":
				deleteEmp(request, response);
				break;
			case "/update":
				updateEmp(request, response);
				break;
			case "/show":
				listEmp(request, response);
				break;
			case "/save":
				saveEmp(request, response);
				break;
			case "/sort":
				sortEmp(request, response);
				break;
			default:
				request.getRequestDispatcher("login.jsp").include(request, response);
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

	private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				dbpass = ManipulateEmp.getAdminCredentials(uname.trim(), pass.trim());
				if (dbpass) {
					HttpSession session = request.getSession(true);
					session.setAttribute("admin_name", uname);
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
/**
 * 
 * @param request
 * @param response
 * @throws Exception
 */
	private void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		session = request.getSession(false);
		if (session.getAttribute("admin_name") != null) {
			session.removeAttribute("admin_name");
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

	private void loginEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = request.getParameter("user_name").trim();
		String pass = request.getParameter("password");

		boolean dbpass = ManipulateEmp.getCredentials(uname, pass);

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

	private void logoutEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

	private void listEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (listEmp == null)
			listEmp = (List<Employee>) ManipulateEmp.getAllEmployee();
		request.setAttribute("listEmp", listEmp);
		request.getRequestDispatcher("adminHome.jsp").forward(request, response);
	}

	private void showRegistrationForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String para = request.getParameter("who");
		System.out.println(para);
		if (para != null & para != "admin") {
			System.out.println("in");
			out.println("<html><body>");
			out.print("<p align=\"center\"> <a style=\"float:left\" href=\"/EmployeeManagement/show\">Home</a></p>");
			out.println("</body></html>");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		} else {
			System.out.println("out");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		}

	}

	private void insertEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

		System.out.println(name);
		System.out.println(gender);
		System.out.println(email);
		System.out.println(mob);
		System.out.println(dob);
		System.out.println(doj);
		System.out.println(address);
		System.out.println(pass);
		System.out.println(cpass);

		if (pass.equals(cpass)) {
			ManipulateEmp.insertEmployee(emp);
			if(request.getSession(false).getAttribute("admin_name")!= null) {
				listEmp = null;
				listEmp(request, response);
			}else {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			out.println("<div align=\"center\"><span style=\" color:red\">Password is Not matching...</span></div>");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		}
	}

	private void updateEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
				emp = ManipulateEmp.getSingleEmployee(id);
				System.out.println("Emp details which going to sort:" + emp);
				request.setAttribute("emp", emp);
				request.getRequestDispatcher("update.jsp").forward(request, response);
			} else {
				listEmp(request, response);
			}
		} else {
			listEmp(request, response);
		}

	}

	private void deleteEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String para = null;
		para = request.getParameter("ids");
		System.out.println("Before Delete##" + para + "##");
		if (para != null) {
			if (!para.equals("")) {
				String empIds = para.trim().replace("n", ",");
				System.out.println("After Delete##" + empIds + "##");
				ManipulateEmp.deleteEmployee(empIds);
				listEmp = null;
				listEmp(request, response);
			} else {
				listEmp(request, response);
			}
		} else {
			listEmp(request, response);
		}
	}

	private void saveEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

		boolean res = ManipulateEmp.updateEmployee(emp);
		if (res) {
			listEmp = null;
			listEmp(request, response);
		}
		else {
			listEmp(request, response);
		}

	}

	private void sortEmp(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
