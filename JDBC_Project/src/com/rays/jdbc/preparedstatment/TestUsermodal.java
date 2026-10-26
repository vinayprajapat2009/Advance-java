package com.rays.jdbc.preparedstatment;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUsermodal {

	public static UserModal modal = new UserModal();

	public static void main(String[] args) throws Exception {

		//testAdd();
		// testdelete();
		// testupdate();
		//testFindBypk();
		//testFindByLogin();
		testsearch();
	}

public static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		UserBean bean = new UserBean();
          
		bean.setfirstName("riya");
		bean.setlastName("sharma");
		bean.setloginId("riya@gmail.com"); 
		bean.setpassword("riya123");
		bean.setdob(sdf.parse("2002-05-04"));

		modal.add(bean);

	}

	public static void testdelete() throws Exception {

		modal.delete(6);

	}

	public static void testupdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean bean = new UserBean();

		
		bean.setfirstName("raja");
		bean.setlastName("thakur");
		bean.setloginId("raja@gmail.com");
		bean.setpassword("raja420");
		bean.setdob(sdf.parse("2000-04-01"));
		bean.setId(5);
		
		modal.update(bean);
	}
	
	public static void testFindBypk() throws Exception {
		
		UserModal modal = new UserModal();
		UserBean bean = new UserBean();
		
		bean = modal.FindBypk(5);
		
		if(bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getfirstName());
			System.out.println(bean.getlastName());
			System.out.println(bean.getloginId());
			System.out.println(bean.getpassword());
			System.out.println(bean.getdob());
		}else {
			System.out.println("user not found");
		}
	}
	
	public static void testFindByLogin() throws Exception {

		UserModal model = new UserModal();
		UserBean bean = new UserBean();

		bean = model.FindByLogin("aayu@gmail.com");
	 	System.out.println(bean.getId());
		System.out.println(bean.getfirstName());
		System.out.println(bean.getlastName());
		System.out.println(bean.getpassword());
		System.out.println(bean.getloginId());
		System.out.println(bean.getdob());

	}
	
	public static void testsearch() throws Exception {
		
		UserModal modal = new UserModal();
		UserBean bean = new UserBean();
		
		List list = modal.search(bean, 1, 5);
		
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getfirstName());
			System.out.println(bean.getlastName());
			System.out.println(bean.getloginId());
			System.out.println(bean.getpassword());
			System.out.println(bean.getdob());
			System.out.println("------------------");			
		}
	}

}