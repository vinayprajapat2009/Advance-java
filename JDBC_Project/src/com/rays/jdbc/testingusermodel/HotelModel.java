package com.rays.jdbc.testingusermodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HotelModel {
       
	public void add(HotelBean bean) throws Exception {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			 
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into hotal values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.gethotelName());
			pstmt.setString(3, bean.getlocation());
			pstmt.setDouble(4, bean.getrating());
			pstmt.setString(5, bean.getcontactNo());
			

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored inserted successfully: " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}
	
	public void update(HotelBean bean) throws Exception {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			conn.setAutoCommit(false);
			
		PreparedStatement pstmt = conn.prepareStatement("update hotal set hotelName = ?, location = ?, rating = ?, contactNo = ? where id = ?");
		
		pstmt.setString(1, bean.gethotelName());
		pstmt.setString(2, bean.getlocation());
		pstmt.setDouble(3, bean.getrating());
		pstmt.setString(4, bean.getcontactNo());
		pstmt.setInt(5, bean.getId());
		
		int i = pstmt.executeUpdate();
		conn.commit();
		System.out.println("recored inserted successfully: " + i);
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
			
		}
		
	}

	public void delete(HotelBean bean) throws Exception {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement pstmt = conn.prepareStatement("delete from hotel where id = ?");
		
		pstmt.setInt(1, bean.getId());
		
		int i = pstmt.executeUpdate();
		conn.commit();
		System.out.println("recored delete successfully: " + i);
			
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
		}
		}

		
	}
		
	
