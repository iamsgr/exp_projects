package com.emp.utiities.comparator;

import java.util.Comparator;
import com.emp.model.Employee;

public class IDComparator implements Comparator<Employee> {

	private static volatile IDComparator cmptr= null;

	static {
		synchronized(IDComparator.class) {
			if(cmptr==null) {
				cmptr = new IDComparator();
			}
		}

	}
	public static IDComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId()==o2.getId()? 0: o1.getId()<o2.getId() ? -1:1;
	}
}
