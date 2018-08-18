package com.emp.controller.employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.service.employee.EmployeeService;

//@WebServlet("/EmployeeControl")
public class EmployeeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeControl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

	   	String action = (String) request.getAttribute("action");
		System.out.println("EmployeeControl:action:"+action);
		try {
			switch (action) {
			
			default:
				response.sendRedirect("login.jsp");
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}
}
