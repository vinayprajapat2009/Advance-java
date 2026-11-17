package com.rays.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;


//1. Single class will provide connection with database.
	//2. Provide Reliable Connection with database.
	public final class JDBCDataSource {


		public static Connection getConnection() {

			ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.app");

			Connection conn = null;

			try {

				Class.forName(rb.getString("driver"));

				conn = DriverManager.getConnection(rb.getString("url"), rb.getString("username"), rb.getString("password"));

			} catch (Exception e) {
				e.printStackTrace();
			}

			return conn;

		}

	}