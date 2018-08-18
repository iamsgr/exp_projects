package com.emp.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.dao.common.DbUtil;
import com.emp.model.admin.Admin;
import com.emp.model.employee.Employee;

public class ManipulateAdmin {
	
	private static Connection con = DbUtil.getConnection();
	
	public static boolean getAdminCredentials(String userName, String userPass) {
		String pass = null;
		try {
			PreparedStatement ps = con.prepareStatement("select adminPassword from AdminDetails where adminName=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pass = rs.getString("adminPassword");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (pass == null)
			return false;
		if (pass.equals(userPass))
			return true;
		else
			return false;
	}

	public static Admin getSingleAdmin(String pass) {
	   Admin admin = null;
		
	   try {
			PreparedStatement ps = con.prepareStatement("select * from AdminDetails where adminPassword=?");
			ps.setString(1, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}
}
