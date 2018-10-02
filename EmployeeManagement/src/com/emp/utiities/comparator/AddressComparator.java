package com.emp.utiities.comparator;

import java.util.Comparator;

import com.emp.model.employee.Employee;

public class AddressComparator implements Comparator<Employee> {

	private static volatile AddressComparator cmptr= null;
	
	private AddressComparator() {}

	static {
		synchronized(AddressComparator.class) {
			if(cmptr==null) {
				cmptr = new AddressComparator();
			}
		}

	}
	public static AddressComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAddress().compareToIgnoreCase(o2.getAddress())==0? 0: o1.getAddress().compareToIgnoreCase(o2.getAddress())<0? -1:1;
	}
}
