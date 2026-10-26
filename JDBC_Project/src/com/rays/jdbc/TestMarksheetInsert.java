package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestMarksheetInsert {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
		
		System.out.println("connection established successfuy...." + conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
			int i = stmt.executeUpdate(
			"insert into marksheet values(7, 107, 'bhenu', 32, 43, 33)");
	
	System.out.println("record inserted " + i + " row affected");
	}

}
