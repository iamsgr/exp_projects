package com.emp.utiities.comparator;

import java.util.Comparator;
import com.emp.model.Employee;

public class GenderComparator implements Comparator<Employee> {
	
	private static volatile GenderComparator cmptr= null;

	static {
		synchronized(GenderComparator.class) {
			if(cmptr==null) {
				cmptr = new GenderComparator();
			}
		}

	}
	public static GenderComparator getInstance() {
		return cmptr;
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getGender().compareToIgnoreCase(o2.getGender())==0? 0: o1.getGender().compareToIgnoreCase(o2.getGender())<0? -1:1;
	}

}
