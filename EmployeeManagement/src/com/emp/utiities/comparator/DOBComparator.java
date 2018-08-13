package com.emp.utiities.comparator;

import java.util.Comparator;
import com.emp.model.Employee;


public class DOBComparator implements Comparator<Employee> {
	
	private static volatile DOBComparator cmptr= null;

	static {
		synchronized(DOBComparator.class) {
			if(cmptr==null) {
				cmptr = new DOBComparator();
			}
		}

	}
	public static DOBComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDob().compareToIgnoreCase(o2.getDob())==0? 0: o1.getDob().compareToIgnoreCase(o2.getDob())<0? -1:1;
	}

}
