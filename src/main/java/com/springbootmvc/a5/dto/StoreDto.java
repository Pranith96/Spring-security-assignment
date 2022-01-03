package com.springbootmvc.a5.dto;

public class StoreDto {

	private String userName;
	private String password;

	public StoreDto() {
	}

	public StoreDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", password=" + password + "]";
	}

}
