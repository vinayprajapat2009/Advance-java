package com.rays.jdbc.preparedstatment;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.management.modelmbean.ModelMBean;

public class TestStudentModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testupdate();
		// testdelete();
//		testfindByPk();
		// testfindByrollNo();
		testSearch();
	}

	public static void testAdd() throws Exception {

		StudentBean bean = new StudentBean();
		Studentmodel model = new Studentmodel();

		bean.setId(11);
		bean.setFirstName("jay");
		bean.setLastName("yadav");
		bean.setRollNo(1111);
		bean.setStudentClass("10th");

		model.add(bean);
	}

	public static void testupdate() throws Exception {

		StudentBean bean = new StudentBean();
		Studentmodel model = new Studentmodel();

		bean.setId(11);
		bean.setFirstName("ram");
		bean.setLastName("yadav");
		bean.setRollNo(1112);
		bean.setStudentClass("11th");

		model.update(bean);
	}

	public static void testdelete() throws Exception {

		Studentmodel model = new Studentmodel();

		model.delete(11);
	}

	public static void testfindByPk() throws SQLException {

		Studentmodel model = new Studentmodel();
		StudentBean bean = new StudentBean();

		bean = model.findByPK(6);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getStudentClass());

	}

	public static void testfindByrollNo() throws SQLException {

		Studentmodel model = new Studentmodel();
		StudentBean bean = new StudentBean();

		bean = model.findByrollNo(1101);

		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getStudentClass());

	}

	public static void testSearch() throws Exception {

		StudentBean bean = new StudentBean();
		Studentmodel model = new Studentmodel();

		List list = model.search(bean, 2, 5);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (StudentBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getStudentClass());

			System.out.println("------------------------");

		}

	}

}
