package com.emp.dao.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.emp.dao.common.DbUtil;
import com.emp.model.employee.Employee;

public class ManipulateEmployee {
	private static Connection con = DbUtil.getConnection();

	public static boolean deleteEmployee(String idArr) {
		String query = null;
		int res = 0;
		try {
			query = "delete from EmpDetails where empID in(" + idArr + ")";
			Statement stmt = con.createStatement();
			res = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (res == 0)
			return false;
		return true;
	}

	public static Employee getSingleEmployee(int id) {
		Employee emp = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from EmpDetails where empID=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	public static boolean updateEmployee(Employee emp) {
		int res=0;
		try {
			PreparedStatement ps = con.prepareStatement(
					"update EmpDetails set empName=? ,empGender=?,empEmail=?, empMobNo=?, empAddress=?, empDOB=?, empDOJ=?, empPassword=? where empID=?");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getGender());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getMobNo());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getDob());
			ps.setString(7, emp.getJoinDate());
			ps.setString(8, emp.getPassword());
			ps.setInt(9, emp.getId());

		res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res==0)
			  return false;
		return true;
	}

	public static Collection<Employee> getAllEmployee() {

		Collection<Employee> c = new ArrayList<Employee>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from EmpDetails");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt("empID"), rs.getString("empName"), rs.getString("empGender"), rs.getString("empEmail"),
						rs.getString("empMobNo"), rs.getString("empAddress"), rs.getString("empDOB"), rs.getString("empDOJ"), rs.getString("empPassword"));
				c.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public static boolean insertEmployee(Employee emp) {
		int res=0;
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO EmpDetails (empName,empGender,empEmail, empMobNo, empAddress, empDOB, empDOJ, empPassword)VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getGender());
			ps.setString(3, emp.getEmail());
			ps.setString(4, emp.getMobNo());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getDob());
			ps.setString(7, emp.getJoinDate());
			ps.setString(8, emp.getPassword());
		    res= ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res==0)
		  return false;
		return true;
	}

	public static int getCredentials(String userName, String userPass) {
		Connection con = DbUtil.getConnection();
		String pass = null;
		int id = 0;
		try {
			PreparedStatement ps = con.prepareStatement("select empPassword, empID from EmpDetails where empEmail=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pass = rs.getString("empPassword");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (pass == null)
			return id;
		if (pass.equals(userPass))
			return id;
		else
			return id;
	}
}
