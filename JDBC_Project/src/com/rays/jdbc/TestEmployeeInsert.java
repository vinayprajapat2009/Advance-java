package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestEmployeeInsert {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "root");

		System.out.println("connection established successfuy...." + conn.getCatalog());

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("insert into employee value(16, 'aayush', 'sales', 35000 )");

		System.out.println("record inserted " + i + " row affected");

	}

}
