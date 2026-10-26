package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws Exception {
		
		Connection conn = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
		
			conn.setAutoCommit(false);
			 
		System.out.println("connection established successfully: " + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
	  
		int i = stmt.executeUpdate(
				"insert into finance values(10, 102, 'Ram', 4000, '2026-12-25')");
		i = stmt.executeUpdate("insert into finance values(11, 104, 'shyam', 3500, '2025-06-05')");
				
		
		System.out.println("record inserted " + i + " row affected");
 
		conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			conn.close();
			
		}
					
		}
	}

