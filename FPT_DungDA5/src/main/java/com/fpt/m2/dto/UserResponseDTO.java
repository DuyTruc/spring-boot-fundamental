package com.fpt.m2.dto;

public class UserResponseDTO {
	public UserResponseDTO(int id, String userName, String email, String address, int phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public UserResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String userName;
	private String email;
	private String address;
	private int phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
