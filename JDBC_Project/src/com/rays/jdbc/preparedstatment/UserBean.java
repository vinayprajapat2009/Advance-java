package com.rays.jdbc.preparedstatment;

import java.util.Date;

public class UserBean {
	
	private int id;
	private String firstName;
	private String lastName;
	private String loginId;
	private String password;
	private Date dob;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	 public String getfirstName() {
		 return firstName;
		 
	 }
	 
	 public void setfirstName(String firstName) {
		 this.firstName = firstName;
	 }
	 
	 public String getlastName() {
		 return lastName;
		 
	 }
	 public void setlastName(String lastName) {
		 this.lastName = lastName;
	 }
	 public String getloginId() {
		 return loginId;
		 
	 }
	 public void setloginId(String loginId) {
		 this.loginId = loginId;
	 }
	 public String getpassword() {
		 return password;
	 }
	 public void setpassword(String password) {
		 this.password = password;
	 }
	 public Date getdob() {
		 return dob;
	 }
	 public void setdob(Date dob) {
		 this.dob = dob;
	 }
	}