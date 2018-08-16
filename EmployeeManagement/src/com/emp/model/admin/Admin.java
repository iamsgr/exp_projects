package com.emp.model.admin;

import com.emp.model.common.Person;

public class Admin extends Person{
    private int id;
    private String password;
    private String mobNo;
     
    public Admin() { super();}
    
	public Admin(int id, String password, String mobNo, String name, String gender, String dob, String address) {
		super(name, gender, dob, address);
		this.id = id;
		this.password=password;
		this.mobNo=mobNo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobNo() {
		return mobNo;
	}

	public void getMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	@Override
	public String toString() {
		return "Admin ["+super.toString()+"id="+ id+" password="+ password+" mobNo="+ mobNo+"]";
	}
	
    
}
