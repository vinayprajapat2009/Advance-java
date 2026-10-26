package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("connection established successfully...." + conn.getCatalog());

		// Statement = executeUpdate(String sql) : int (insert, update, delete)
		// Statement = executeQuery(String sql) : ResulSet (select)

	}

}
