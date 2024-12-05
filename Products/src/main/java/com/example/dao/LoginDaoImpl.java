package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.beans.Person;
import com.example.beans.User;

public class LoginDaoImpl implements LoginDao {
	private static Connection con;
	private static PreparedStatement plogin, pinsertper, pinsertu, pverify, pupdatepass;
	static {
		try {
			plogin = DBUtil.getConnection().prepareStatement("select * from userlogin where username=? and password=?");
			pinsertper = DBUtil.getConnection().prepareStatement("insert into person(firstname, lastname, gender, city) values(?, ?, ?, ?)");
			pinsertu = DBUtil.getConnection().prepareStatement("insert into userlogin(username, password, role) values(?, ?, ?)");
			pverify = DBUtil.getConnection().prepareStatement("select username, password, role from userlogin where username=?");
			pupdatepass = DBUtil.getConnection().prepareStatement("update userlogin set password=? where username=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public User validateUser(User u) {
		try {
			plogin.setString(1, u.getUsername());
			plogin.setString(2, u.getPassword());
			ResultSet rs = plogin.executeQuery();
			while(rs.next()) {
				u.setRole(rs.getString("role"));
				return u;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveData(Person p, User u) {
		try {
			System.out.println(p.getFirstname());
			System.out.println(p.getLastname());
			pinsertper.setString(1, p.getFirstname());
			pinsertper.setString(2, p.getLastname());
			pinsertper.setString(3, p.getGender());
			pinsertper.setString(4, p.getCity());
			int r = pinsertper.executeUpdate();
			pinsertu.setString(1, u.getUsername());
			pinsertu.setString(2, u.getPassword());
			pinsertu.setString(3, u.getRole());
			int s = pinsertu.executeUpdate();
			if(r>0 && s>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}


	private boolean UpdatePassword(User u) {
		try {
			pupdatepass.setString(1, u.getPassword());
			pupdatepass.setString(2, u.getUsername());
			if(pupdatepass.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean exists(User u) {
		try {
			pverify.setString(1, u.getUsername());
			ResultSet rs = pverify.executeQuery();
			if(rs.next()) {
				boolean result = UpdatePassword(u);
				if(result) {
					return true;
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
}
