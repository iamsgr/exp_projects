package com.emp.controller.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.service.common.CommonService;

//@WebServlet("/CommonControl")
public class CommonControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommonControl() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println("CommonControl:action:"+action);
		try {
			switch (action) {
			
			case "/registration":
				CommonService.showRegistrationForm(request, response);
				break;
			case "/add":
				CommonService.insertEmp(request, response);
				break;
			case "/delete":
				CommonService.deleteEmp(request, response);
				break;
			case "/update":
				CommonService.updateEmp(request, response);
				break;
			case "/save":
				CommonService.saveEmp(request, response);
				break;
			default:
				request.setAttribute("action", action);
				if(action.split("/")[1].equals("admin")) {
					request.getRequestDispatcher("/admin").forward(request, response);
				}
				else if(action.split("/")[1].equals("emp")) {
					request.getRequestDispatcher("/emp").forward(request, response);

				}else
					response.sendRedirect("registration.jsp");
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}
}
