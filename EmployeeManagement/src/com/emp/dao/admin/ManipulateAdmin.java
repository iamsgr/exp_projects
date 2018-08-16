package com.emp.dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.emp.dao.common.DbUtil;

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
}
