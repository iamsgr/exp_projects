package com.emp.model.employee;

import com.emp.model.common.Person;

public class Employee extends Person {
	 private final String WHO = "employee";
	 private int id;
	 private String email;
	 private String mobNo;
	 private String joinDate;
	 private String password;
	 
	public Employee() {
		super();
	}

	public Employee(int id, String name, String gender, String email, String mobNo, String address, String dob, String joinDate, String password) {
		super(name, gender, dob, address);
		this.id = id;
		this.email = email;
		this.mobNo = mobNo;
		this.joinDate = joinDate;
		this.password = password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password ) {
		this.password = password;
	}
	
	public String getWHO() {
		return WHO;
	}
	
	@Override
	public String toString() {
		return "Employee ["+super.toString()+"id=" + id + ", email=" + email + ", mobNo=" + mobNo + ", password=" + password + ", joinDate=" + joinDate +"]";
	}
	
	
}
