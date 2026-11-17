package com.rays.jdbc.preparedstatment;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class TestSchoolManagementModel {

	public static void main(String[] args) throws Exception {

//		testAdd();
//		testUpdate();
//		testdelete();
//		testfindByPk();
		testsearch();

	}

	public static void testAdd() throws Exception {

		SchoolManagementBean bean = new SchoolManagementBean();
		SchoolManagementModel model = new SchoolManagementModel();

		bean.setSchoolId(6);
		bean.setName("Bal Vinay mandir");
		bean.setAddress("indore");
		bean.setTotalStudent(800);
		bean.setPrincipal("komal sharma");

		model.add(bean);

	}

	private static void testUpdate() throws Exception {

		SchoolManagementBean bean = new SchoolManagementBean();
		SchoolManagementModel model = new SchoolManagementModel();

		bean.setSchoolId(3);
		bean.setName("Indore Public School");
		bean.setAddress("indore");
		bean.setTotalStudent(500);
		bean.setPrincipal("Ranjeet Yadav");

		model.update(bean);

	}

	public static void testdelete() throws Exception {
		SchoolManagementModel model = new SchoolManagementModel();

		model.delete(2);
	}

	public static void testfindByPk() throws SQLException {

		SchoolManagementBean bean = new SchoolManagementBean();
		SchoolManagementModel model = new SchoolManagementModel();

		bean = model.findByPK(4);

		System.out.println(bean.getSchoolId());
		System.out.println(bean.getName());
		System.out.println(bean.getAddress());
		System.out.println(bean.getTotalStudent());
		System.out.println(bean.getPrincipal());
	}

	public static void testsearch() throws Exception {

		SchoolManagementBean bean = new SchoolManagementBean();
		SchoolManagementModel model = new SchoolManagementModel();

		List list = model.search(bean, 1, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (SchoolManagementBean) it.next();
			System.out.println(bean.getSchoolId());
			System.out.println(bean.getName());
			System.out.println(bean.getAddress());
			System.out.println(bean.getTotalStudent());
			System.out.println(bean.getPrincipal());
			System.out.println("------------------");
		}
	}
}