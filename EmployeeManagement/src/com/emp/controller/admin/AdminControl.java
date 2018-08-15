package com.emp.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.employee.Employee;
import com.emp.service.admin.AdminService;
import com.emp.service.common.CommonService;

//@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public AdminControl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String action = (String) request.getAttribute("action");
    	System.out.println("AdminControl:action:"+ action);
    	try {
    		switch (action) {
    		
    		case "/admin/adminLogin":
    			AdminService.loginAdmin(request, response);
    			break;
    		case "/admin/adminHome":
    			if(request.getSession(false).getAttribute("admin_name") == null)
    				request.getRequestDispatcher("login.jsp").include(request, response);
    			else
    				AdminService.listEmp(request, response);
    			break;
    		case "/admin/adminLogout":
    			AdminService.logoutAdmin(request, response);
    			break;
    		case "/admin/add":
    			CommonService.insertEmp(request, response);
    			break;
    		case "/admin/show":
    			AdminService.listEmp(request, response);
    			break;
    		case "/admin/sort":
    			AdminService.sortEmp(request, response);
    			break;
    		default:
    			response.sendRedirect("adminLogin.jsp");
    			break;
    		}
    	 } catch (Exception ex) {
    		ex.printStackTrace();
    		throw new ServletException(ex);
    	}
     }
}
