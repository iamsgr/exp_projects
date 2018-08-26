package com.emp.dao;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DbUtil {
	private static volatile Connection con;
	
	private DbUtil() { }
	//static block
	static {
		Properties prop = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("db.properties");
		try {
			//loading property file
			prop.load(input);
		}catch(IOException e){
			e.printStackTrace();
		}
		String driver = prop.getProperty("jdbc_driver");
		String url = prop.getProperty("jdbc_url");
		String user = prop.getProperty("user");
		String pwd =  prop.getProperty("password");
		try {
			Class.forName(driver);
            synchronized(DbUtil.class) {
    			if(con == null)
    				con = DriverManager.getConnection(url,user,pwd);
            }
		}catch(Exception e) { e.printStackTrace(); }
	}
	
	public static Connection getConnection() {
		return con;
	}
}
















