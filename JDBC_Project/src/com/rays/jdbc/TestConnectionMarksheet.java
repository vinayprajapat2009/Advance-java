package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnectionMarksheet {
	
public static void main(String[] args) throws Exception {
		
		// step 1. load Driver class into the class loader
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		// step 2. Make Connection to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "root");
		
		
		System.out.println("connection established successfully...." + conn.getCatalog());
		
		
		//step 3. create statement and get Resultset or insert, update and delete
		//records
		 Statement stmt = conn.createStatement();
		 
		 //step 4. get records 
		 ResultSet rs = stmt.executeQuery("select * from marksheet");
		 
		 while(rs.next()) {
			 System.out.println(rs.getInt("id"));
			 System.out.println(rs.getInt("roll_No"));
			 System.out.println(rs.getString("name"));
			 System.out.println(rs.getInt("phy"));
			 System.out.println(rs.getInt("chm"));
			 System.out.println(rs.getInt("maths"));
			 System.out.println("--------------");
		 }

}
}
