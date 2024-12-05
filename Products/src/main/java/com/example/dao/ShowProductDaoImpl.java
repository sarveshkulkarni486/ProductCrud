package com.example.dao;

import com.example.beans.Product;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class ShowProductDaoImpl implements ShowProductDao {
	private static Connection con;
	private static PreparedStatement pins, psel, pbyid, pupdate, pdelete;
	static {
		try {
			con = DBUtil.getConnection();
			pins = con.prepareStatement("insert into productdetails values(?, ?, ?, ?, ?, ?)");
			psel = con.prepareStatement("select * from productdetails");
			pbyid = con.prepareStatement("select pid, pname, qty, price, expdate, cid from productdetails where pid=?");
			pupdate = con.prepareStatement("update productdetails set pname=?, qty=?, price=?, expdate=?, cid=? where pid=?");
			pdelete = con.prepareStatement("delete from productdetails where pid = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean AddProduct(Product p) {
		try {
			pins.setInt(1, p.getPid());
			pins.setString(2, p.getPname());
			pins.setInt(3, p.getQty());
			pins.setDouble(4, p.getPrice());
			pins.setDate(5, java.sql.Date.valueOf(p.getExpdate()));
			pins.setInt(6, p.getCid());
			if(pins.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> DisplayProduct() {
		try {
			ResultSet rs = psel.executeQuery();
			List<Product> plist = new ArrayList();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6)));
			}
			if(plist.size()>0) {
				return plist;
			}
			
		}catch(SQLException sq) {
			sq.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getById(int pid) {
		try {
			pbyid.setInt(1, pid);
			ResultSet rs = pbyid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDate(5).toLocalDate(), rs.getInt(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean modifyProduct(Product p) {
		try {
			pupdate.setString(1, p.getPname());
			pupdate.setInt(2, p.getQty());
			pupdate.setDouble(3, p.getPrice());
			pupdate.setDate(4, java.sql.Date.valueOf(p.getExpdate()));
			pupdate.setInt(5, p.getCid());
			pupdate.setInt(6, p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getQty());
			System.out.println(p.getPrice());
			System.out.println(p.getExpdate());
			System.out.println(p.getCid());
			
			int res = pupdate.executeUpdate();
			if(res>0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean delete(int pid) {
		System.out.println(pid);
		try {
			pdelete.setInt(1, pid);
			if(pdelete.executeUpdate()>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
