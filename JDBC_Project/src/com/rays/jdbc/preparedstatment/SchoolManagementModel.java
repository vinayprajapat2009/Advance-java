package com.rays.jdbc.preparedstatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JDBCDataSource;

public class SchoolManagementModel {
	public int nextPk() throws Exception {

		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select max(id) from schoolmanagement");

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

	public static void add(SchoolManagementBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into schoolmanagement values (?,?,?,?,?)");

			pstmt.setInt(1, bean.getSchoolId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getAddress());
			pstmt.setInt(4, bean.getTotalStudent());
			pstmt.setString(5, bean.getPrincipal());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record inserted sucessfully: " + 1);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public static void update(SchoolManagementBean bean) throws Exception {
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update schoolmanagement set name = ?, address = ?, TotalStudent = ?, Principal = ? where schoolId= ?");

			pstmt.setInt(5, bean.getSchoolId());
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getAddress());
			pstmt.setInt(3, bean.getTotalStudent());
			pstmt.setString(4, bean.getPrincipal());

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("record updated sucessfully: " + 1);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}
	}

	public static void delete(int schoolId) throws Exception {

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from schoolmanagement where id = ?");

			pstmt.setInt(1, schoolId);

			int i = pstmt.executeUpdate();
			conn.commit();
			System.out.println("recored deleted sucessfully: " + i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public SchoolManagementBean findByPK(int schoolId) throws SQLException {

		Connection conn = null;
		SchoolManagementBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from schoolmanagement where schoolId = ?");

			pstmt.setInt(1, schoolId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new SchoolManagementBean();
				bean.setSchoolId(rs.getInt("scholId"));
				bean.setName(rs.getString("name"));
				bean.setAddress(rs.getString("address"));
				bean.setTotalStudent(rs.getInt("totalStudent"));
				bean.setPrincipal(rs.getString("principal"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

	public List<SchoolManagementBean> search(SchoolManagementBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = null;
		List<SchoolManagementBean> list = new ArrayList<SchoolManagementBean>();
		StringBuffer sql = new StringBuffer("select * from schoolmanagement where 1=1 ");

		if (bean != null) {
			if (bean.getSchoolId() > 0) {
				sql.append("and id = " + bean.getSchoolId());
			}

		}

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append("limit " + index + ", " + pageSize);
		}

		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new SchoolManagementBean();
			bean.setSchoolId(rs.getInt("schoolId"));
			bean.setName(rs.getString("name"));
			bean.setAddress(rs.getString("address"));
			bean.setTotalStudent(rs.getInt("totalStudent"));
			bean.setPrincipal(rs.getString("principal"));
			list.add(bean);
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}
}
