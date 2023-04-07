package com.example.demo.Dto;

import java.sql.Date;




public class userDto {
	

	private Long Id;
	private String UserName;
	private String Password;
	private Date loginDate;
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public String toString() {
		return "userDto [Id=" + Id + ", UserName=" + UserName + ", Password=" + Password + ", loginDate=" + loginDate
				+ "]";
	}
	public userDto() {
		super();
	}
	
}
