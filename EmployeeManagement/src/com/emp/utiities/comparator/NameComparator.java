package com.emp.utiities.comparator;

import java.util.Comparator;

import com.emp.model.employee.Employee;

public class NameComparator implements Comparator<Employee> {

	private static volatile NameComparator cmptr = null;

	static {
		synchronized (NameComparator.class) {
			if (cmptr == null) {
				cmptr = new NameComparator();
			}
		}

	}

	public static NameComparator getInstance() {
		return cmptr;
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareToIgnoreCase(o2.getName())==0? 0: o1.getName().compareToIgnoreCase(o2.getName())<0? -1:1;
	}

}
