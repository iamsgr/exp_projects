package com.emp.service.admin;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.dao.employee.ManipulateEmployee;
import com.emp.model.employee.Employee;
import com.emp.utiities.comparator.AddressComparator;
import com.emp.utiities.comparator.DOBComparator;
import com.emp.utiities.comparator.DOJComparator;
import com.emp.utiities.comparator.EmailComparator;
import com.emp.utiities.comparator.GenderComparator;
import com.emp.utiities.comparator.IDComparator;
import com.emp.utiities.comparator.MobileComparator;
import com.emp.utiities.comparator.NameComparator;

public class AdminService {
	
	public static List<Employee> listEmp = null;
	
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
					Collections.sort(listEmp, NameComparator.getInstance());
					listEmp(request, response);
					break;
				case "gender":
					Collections.sort(listEmp, GenderComparator.getInstance());
					listEmp(request, response);
					break;
				case "email":
					Collections.sort(listEmp, EmailComparator.getInstance());
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
