package com.emp.utiities.comparator;

import java.util.Comparator;

import com.emp.model.employee.Employee;

public class MobileComparator implements Comparator<Employee> {
	
	private static volatile MobileComparator cmptr= null;

	static {
		synchronized(MobileComparator.class) {
			if(cmptr==null) {
				cmptr = new MobileComparator();
			}
		}

	}
	public static MobileComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getMobNo().compareTo(o2.getMobNo())==0? 0: o1.getMobNo().compareTo(o2.getMobNo())<0? -1:1;
	}

}
