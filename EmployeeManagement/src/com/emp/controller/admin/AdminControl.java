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
    	
    	String action= null;
    	action = (String) request.getAttribute("action");
    	//action = request.getServletPath();
    	if(action != null) {
        	System.out.println("AdminControl:action:"+ action);
        	try {
        		switch (action) {
        		case "/admin/adminHome":
        			if(request.getSession(false).getAttribute("user") == null)
        				request.getRequestDispatcher("/login.jsp").include(request, response);
        			else
        				AdminService.listEmp(request, response);
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
        			response.sendRedirect(request.getContextPath()+"/adminHome.jsp");
        			break;
        		}
        	 } catch (Exception ex) {
        		ex.printStackTrace();
        		throw new ServletException(ex);
        	}
         }else {
        	 response.sendRedirect(request.getContextPath()+"/adminLogin.jsp");
         }
    	}

}
