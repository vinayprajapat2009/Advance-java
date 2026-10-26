package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestDelete {
	
	
		public static void main(String[] args) throws Exception {
			
			Connection conn = null;
			
			try {		
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");
			 
			conn.setAutoCommit(false);
			
			System.out.println("connection established successfully...." + conn.getCatalog());
			
			Statement stmt = conn.createStatement();
			 
			 int i = stmt.executeUpdate("delete from finance where id = 10");
			 
			 conn.commit();
			 
			 System.out.println("record delete " + i + " row affected");
			
			} catch (Exception e) {
				e.printStackTrace();
				conn.rollback();
			}finally {
				conn.close();
			}
		 
			 
	}

}
