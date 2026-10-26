package com.rays.jdbc.preparedstatment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPatientModel {
	
	public static void main(String[] args) throws Exception {
		
//		testAdd();
//		testupdate();
		testdelete();
		
	}
	
	public static void testAdd() throws Exception {
		PatientBean bean = new PatientBean();
		PatientModel model = new PatientModel();
		
		bean.setId(11);
		bean.setName("jay");
		bean.setAge(18);
		bean.setBloodGroup("B-");
		bean.setDisease("fever");
		
		model.add(bean);
		
	}
	public static void testupdate() throws Exception {
		PatientBean bean = new PatientBean();
		PatientModel model = new PatientModel();
		
		bean.setId(11);
		bean.setName("aayush");
		bean.setAge(20);
		bean.setBloodGroup("A+");
		bean.setDisease("fever");
		
		model.update(bean);
}
	
	public static void testdelete() throws Exception{
		
		PatientModel model = new PatientModel();
		
		model.delete(11);
	}
}