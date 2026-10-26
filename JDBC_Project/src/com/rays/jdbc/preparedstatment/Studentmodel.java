package com.rays.jdbc.preparedstatment;

import java.nio.file.attribute.AclEntry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Studentmodel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.jdbc.bundle.app");

	String url = rb.getString("url");
	String driver = rb.getString("driver");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public static void add(StudentBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("driver");

			conn = DriverManager.getConnection("url", "username", "password");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_Student values(?,?,?,?,?)");

			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setInt(4, bean.getRollNo());
			pstmt.setString(5, bean.getStudentClass());

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("recored inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public static void update(StudentBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("driver");

			conn = DriverManager.getConnection("url", "username", "password");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_Student set FristName = ?, lastName = ?, rollNo = ?, StudentClass = ? where id = ? ");

			pstmt.setInt(5, bean.getId());
			pstmt.setString(1, bean.getFirstName());
			pstmt.setString(2, bean.getLastName());
			pstmt.setInt(3, bean.getRollNo());
			pstmt.setString(4, bean.getStudentClass());

			int i = pstmt.executeUpdate();
			conn.commit();

			System.out.println("recored updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public static void delete(int id) throws Exception {

		Connection conn = null;

		try {
			Class.forName("driver");

			conn = DriverManager.getConnection("url", "username", "password");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_Student where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored deleted successfully: " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

//findByPK(int id) = select * from st_Student where id = ?
//findByLogin(String LoginId) = select * from st_Student where LoginId = ?
//authenticate(String LoginId, String Password) = select * from st_Student where LoginId = ? and Password = ?

	public StudentBean findByPK(int id) throws SQLException {

		Connection conn = null;
		StudentBean bean = null;

		try {
			Class.forName("driver");

			conn = DriverManager.getConnection("url", "username", "password");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_Student where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setStudentClass(rs.getString("StudentClass"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}

	public StudentBean findByrollNo(int rollNo) throws SQLException {

		Connection conn = null;
		StudentBean bean = null;

		try {
			Class.forName("driver");

			conn = DriverManager.getConnection("url", "username", "password");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_Student where rollNo = ?");

			pstmt.setInt(1, rollNo);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new StudentBean();
				bean.setId(rs.getInt("Id"));
				bean.setFirstName(rs.getString("firstName"));
				bean.setLastName(rs.getString("lastName"));
				bean.setRollNo(rs.getInt("rollNo"));
				bean.setStudentClass(rs.getString("StudentClass"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}

	public List<StudentBean> search(StudentBean bean, int pageNo, int pageSize) throws Exception {

		List<StudentBean> list = new ArrayList<StudentBean>();

		Connection conn = null;

		StringBuffer sql = new StringBuffer("SELECT * FROM st_Student WHERE 1=1");

		if (bean != null) {

			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}

			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {

				sql.append(" AND firstName LIKE '" + bean.getFirstName() + "%'");
			}

			if (bean.getLastName() != null && bean.getLastName().length() > 0) {

				sql.append(" AND lastName LIKE '" + bean.getLastName() + "%'");
			}

			if (bean.getRollNo() > 0) {
				sql.append(" AND rollNo = " + bean.getRollNo());
			}

			if (bean.getStudentClass() != null && bean.getStudentClass().length() > 0) {

				sql.append(" AND StudentClass LIKE '" + bean.getStudentClass() + "%'");
			}
		}

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append(" LIMIT " + index + ", " + pageSize);
		}

		System.out.println("sql ===> " + sql);

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				StudentBean student = new StudentBean();

				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setRollNo(rs.getInt("rollNo"));
				student.setStudentClass(rs.getString("StudentClass"));

				list.add(student);
			}

		} finally {

			if (conn != null) {
				conn.close();
			}
		}

		return list;
	}

}
