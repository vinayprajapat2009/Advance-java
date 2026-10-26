package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestMarksheetUpdate {
	public static void main(String[] args) throws Exception {
		
	
	// step 1. load Driver class into the class loader
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// step 2. Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
		

		System.out.println("connection established successfuy...." + conn.getCatalog());
		
		
		//step 3. create statement and get Resultset or insert, update and delete
		//records
		 Statement stmt = conn.createStatement();
		 
		  int i = stmt.executeUpdate("update marksheet SET name = 'divya' WHERE id =5;");
		         System.out.println("record update " + i + " row affected");


}
}