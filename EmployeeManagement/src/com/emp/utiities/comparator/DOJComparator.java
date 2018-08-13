package com.emp.utiities.comparator;

import java.util.Comparator;
import com.emp.model.Employee;


public class DOJComparator implements Comparator<Employee> {
	
	private static volatile DOJComparator cmptr= null;

	static {
		synchronized(DOJComparator.class) {
			if(cmptr==null) {
				cmptr = new DOJComparator();
			}
		}

	}
	public static DOJComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getJoinDate().compareToIgnoreCase(o2.getJoinDate())==0? 0: o1.getJoinDate().compareToIgnoreCase(o2.getJoinDate())<0? -1:1;
	}

}
