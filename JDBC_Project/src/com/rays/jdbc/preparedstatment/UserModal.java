package com.rays.jdbc.preparedstatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserModal {
	public int nextPk() throws Exception {

		Connection conn = null;
		int pk = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
				System.out.println("max id: " + pk);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {

		Connection conn = null;

		UserBean existBean = FindByLogin(bean.getloginId());
		if (existBean != null) {
			throw new RuntimeException("loginId already exist");
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?,?,?,?,?,?)");

			pstmt.setInt(1, nextPk());
			pstmt.setString(2, bean.getfirstName());
			pstmt.setString(3, bean.getlastName());
			pstmt.setString(4, bean.getloginId());
			pstmt.setString(5, bean.getpassword());
			pstmt.setDate(6, new java.sql.Date(bean.getdob().getTime()));

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored inserted successfully: " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void update(UserBean bean) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update st_user set firstName = ?, lastName = ?, loginId = ?, password = ?, dob = ? where id = ?");

			pstmt.setInt(6, bean.getId());
			pstmt.setString(1, bean.getfirstName());
			pstmt.setString(2, bean.getlastName());
			pstmt.setString(3, bean.getloginId());
			pstmt.setString(4, bean.getpassword());
			pstmt.setDate(5, new java.sql.Date(bean.getdob().getTime()));

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored updated successfully: " + i);

		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public void delete(int id) throws Exception {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored delete successfully :" + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	// Findbypk() == select * from st_user where id = ?
	// Findbylogin() == select * from st_user where loginId = ?
	// authenticate() == select * from st_user where id = ? and password = ?

	public UserBean FindBypk(int id) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();

				bean.setId(rs.getInt("id"));
				bean.setfirstName(rs.getString("firstName"));
				bean.setlastName(rs.getString("lastName"));
				bean.setloginId(rs.getNString("loginId"));
				bean.setpassword(rs.getString("password"));
				bean.setdob(rs.getDate("dob"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

	public UserBean FindByLogin(String loginId) throws Exception {

		Connection conn = null;
		UserBean bean = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

			PreparedStatement pstmt = conn.prepareStatement("select * from st_user where loginId = ?");

			pstmt.setString(1, loginId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setfirstName(rs.getString("firstName"));
				bean.setlastName(rs.getString("lastName"));
				bean.setloginId(rs.getString("loginId"));
				bean.setpassword(rs.getString("password"));
				bean.setdob(rs.getDate("dob"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

	public UserBean authenticate(String loginId, String password) throws Exception {

		UserBean bean = new UserBean();

		bean = FindByLogin(loginId);

		if (bean != null && bean.getpassword().equals(password)) {
			return bean;
		}

		return null;

	}

	public List search(UserBean bean, int page, int pageSize) throws Exception {

		StringBuffer sql = new StringBuffer("select * from st_user where 1=1"); // where 1=1 is sql injection
		List list = new ArrayList();
		Connection conn = null;

		try {
			if (bean != null) {
				if (bean.getId() > 0) {
					sql.append("and id = " + bean.getId());
				}
				if (bean.getfirstName() != null && bean.getfirstName().length() > 0) {
					sql.append("and firstName like '" + bean.getfirstName() + "%'");
				}
				if (bean.getlastName() != null && bean.getlastName().length() > 0) {
					sql.append("and lastName like '" + bean.getlastName().length() + "%'");
				}
				if (bean.getloginId() != null && bean.getloginId().length() > 0) {
					sql.append(" and loginId = '" + bean.getloginId() + "'");
				}
				if (bean.getpassword() != null && bean.getpassword().length() > 0) {
					sql.append("and password = '" + bean.getpassword() + "'");
				}
				if (bean.getdob() != null && bean.getdob().getTime() > 0) {
					sql.append("and dob = '" + new java.sql.Date(bean.getdob().getTime()) + "'");
				}

			}
			if (pageSize > 0) {
				int index = (page - 1) * pageSize;
				sql.append(" limit " + index + "," + pageSize);

			}  
			System.out.println("sql ====> " + sql.toString());

			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getInt("id"));
				bean.setfirstName(rs.getString("firstName"));
				bean.setlastName(rs.getString("lastName"));
				bean.setloginId(rs.getString("loginId"));
				bean.setpassword(rs.getString("loginId"));
				bean.setdob(rs.getDate("dob"));
				list.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}
}
