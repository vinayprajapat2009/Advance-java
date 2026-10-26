package com.rays.jdbc.testingusermodel;

import com.rays.jdbc.preparedstatment.UserBean;
import com.rays.jdbc.preparedstatment.UserModal;

public class TestHotelModel {

	public static HotelModel model = new HotelModel();

	public static void main(String[] args) throws Exception {

		//testAdd();
		//testupdate();
		testdelete();
	}

	public static void testAdd() throws Exception {

		HotelBean bean1 = new HotelBean();

		bean1.setId(12);
		bean1.sethotelName("'Desert Rose Hotel");
		bean1.setlocation("Jaisalmer");
		bean1.setrating(7000.0);
		bean1.setcontactNo("8080808080");

		model.add(bean1);

	}

	public static void testupdate() throws Exception {

		HotelBean bean1 = new HotelBean();

		bean1.sethotelName("RolaxIn");
		bean1.setlocation("indore");
		bean1.setrating(7000.0);
		bean1.setcontactNo("5763248744");
		bean1.setId(111);

		model.update(bean1);
	}
	
	public static void testdelete() throws Exception {
		
		HotelBean bean1 = new HotelBean();
		
		bean1.setId(12);
		
	 model.delete(bean1);
	 }
}


