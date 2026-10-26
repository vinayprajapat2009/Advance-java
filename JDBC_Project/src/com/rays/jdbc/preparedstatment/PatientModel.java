package com.rays.jdbc.preparedstatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientModel {

	public static void add(PatientBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into patient values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getAge());
			pstmt.setString(4, bean.getBloodGroup());
			pstmt.setString(5, bean.getDisease());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted sucessfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public static void update(PatientBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn
					.prepareStatement("update patient set name = ?, age = ?, bloodGroup = ?, Disease = ? where id = ?");

			pstmt.setInt(5, bean.getId());
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getAge());
			pstmt.setString(3, bean.getBloodGroup());
			pstmt.setString(4, bean.getDisease());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated sucessfully" + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}

	public static void delete(int id) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from patient where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();
			System.out.println("record deleted sucessfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

	}
}


	