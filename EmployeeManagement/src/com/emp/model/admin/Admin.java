package com.emp.model.admin;

import com.emp.model.common.Person;

public class Admin extends Person{
	private final String WHO = "admin"; 
    private int id;
    private String password;
    private String mobNo;
    private String email;
     
    public Admin() { super();}
    
	public Admin(int id, String name, String email, String password, String gender, String dob, String address, String mobNo) {
		super(name, gender, dob, address);
		this.id = id;
		this.password = password;
		this.mobNo = mobNo;
		this.email = email;
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

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWHO() {
		return WHO;
	}
	
	@Override
	public String toString() {
		return "Admin ["+super.toString()+"id="+ id+" password="+ password+" mobNo="+ mobNo+"]";
	}
	
    
}
