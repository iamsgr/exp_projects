package com.emp.utiities.comparator;

import java.util.Comparator;

import com.emp.model.employee.Employee;


public class EmailComparator implements Comparator<Employee> {
	
	private static volatile EmailComparator cmptr= null;

	static {
		synchronized(EmailComparator.class) {
			if(cmptr==null) {
				cmptr = new EmailComparator();
			}
		}

	}
	public static EmailComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getEmail().compareToIgnoreCase(o2.getEmail())==0? 0: o1.getEmail().compareToIgnoreCase(o2.getEmail())<0? -1:1;
	}

}
