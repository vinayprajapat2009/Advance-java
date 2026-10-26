package com.rays.jdbc.preparedstatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MarksheetModel {

	public static void add(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");

			pstmt.setInt(1, bean.getChm());
			pstmt.setInt(2, bean.getRollNo());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhy());
			pstmt.setInt(5, bean.getChm());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("recored inserted sucessfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public static void update(MarksheetBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_marksheet set rollNo = ?, name = ?, phy = ?, chm = ?, maths = ? where = ?");

			pstmt.setInt(6, bean.getId());
			pstmt.setInt(1, bean.getRollNo());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhy());
			pstmt.setInt(4, bean.getChm());
			pstmt.setInt(5, bean.getMaths());

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("recored updated sucessfully: " + i);
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

			PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored deleted sucessfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public MarksheetBean findByPK(int id) throws SQLException {

		Connection conn = null;
		MarksheetBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt("id"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setName(rs.getString("name"));
				bean.setPhy(rs.getInt("phy"));
				bean.setChm(rs.getInt("chm"));
				bean.setMaths(rs.getInt("maths"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

	public MarksheetBean findByrollNo(int rollNo) throws SQLException {

		Connection conn = null;
		MarksheetBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where rollNo = ?");

			pstmt.setInt(1, rollNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new MarksheetBean();
				bean.setId(rs.getInt("id"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setName(rs.getString("name"));
				bean.setPhy(rs.getInt("phy"));
				bean.setChm(rs.getInt("chm"));
				bean.setMaths(rs.getInt("maths"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

}