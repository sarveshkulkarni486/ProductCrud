package com.example.dao;
import java.sql.*;
public class DBUtil {
	private static Connection con;
	private static String url;
	private static String user;
	private static String password;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			url = "jdbc:mysql://192.168.10.127:3306/dac78";
			user = "dac78";
			password = "welcome";
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		try{
			con = DriverManager.getConnection(url, user, password);
			if(con!=null) {
				return con;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
