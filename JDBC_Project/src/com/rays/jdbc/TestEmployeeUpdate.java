package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestEmployeeUpdate {
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("connection established successfuy...." + conn.getCatalog());

		Statement stmt = conn.createStatement();
			
		  int i = stmt.executeUpdate("update Employee SET name = 'vinay' WHERE id =16;");
	         System.out.println("record update " + i + " row affected");

	}
}
