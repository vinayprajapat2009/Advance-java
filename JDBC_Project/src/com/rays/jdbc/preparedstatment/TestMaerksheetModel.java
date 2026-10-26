package com.rays.jdbc.preparedstatment;

import java.sql.SQLException;

public class TestMaerksheetModel {
	
     public static void main(String[] args) throws Exception {
    	 
//  	 testAdd();
//    	 testupdate();
//    	 testdelete();
//    	 testfindByPk();
    	 testfindByrollNo();
    	 
}
     public static void testAdd() throws Exception {
    	 
    	 MarksheetBean bean = new MarksheetBean();
    	 MarksheetModel model = new MarksheetModel();
    	 
    	 bean.setId(8);
    	 bean.setRollNo(208);
    	 bean.setName("sona");
    	 bean.setPhy(34);
    	 bean.setChm(65);
    	 bean.setMaths(55);
    	 
    	 model.add(bean);
    	 
    	 
     }
    public static void testupdate() throws Exception {
    	 
    	 MarksheetBean bean = new MarksheetBean();
    	 MarksheetModel model = new MarksheetModel();
    	 
    	 bean.setId(6);
    	 bean.setRollNo(208);
    	 bean.setName("sona");
    	 bean.setPhy(34);
    	 bean.setChm(65);
    	 bean.setMaths(55);
    	 
    	 model.add(bean);
    	 
    }
    
    public static void testdelete()throws Exception{
    	MarksheetModel model = new MarksheetModel();
    	
    	model.delete(7);
    }
    public static void testfindByPk() throws SQLException {
		  
		 MarksheetBean bean = new MarksheetBean();
		 MarksheetModel model = new MarksheetModel();
		 
		 bean = model.findByPK(6);
		 
		 System.out.println(bean.getId());
		 System.out.println(bean.getRollNo());
		 System.out.println(bean.getName());
		 System.out.println(bean.getPhy());
		 System.out.println(bean.getChm());
		 System.out.println(bean.getMaths());
	 }
    
    public static void testfindByrollNo() throws SQLException {
		  
		 MarksheetBean bean = new MarksheetBean();
		 MarksheetModel model = new MarksheetModel();
		 
		 bean = model.findByrollNo(203);
		 
		 System.out.println(bean.getId());
		 System.out.println(bean.getRollNo());
		 System.out.println(bean.getName());
		 System.out.println(bean.getPhy());
		 System.out.println(bean.getChm());
		 System.out.println(bean.getMaths());

}
}