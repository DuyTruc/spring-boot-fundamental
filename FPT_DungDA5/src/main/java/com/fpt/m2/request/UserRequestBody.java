package com.fpt.m2.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestBody {

	public UserRequestBody(int id, @NotBlank(message = "userName not bank.") @Size(max = 45) String userName,
			@Size(max = 45) String email, @Size(max = 45) String address, @Min(0) @Max(2147483647) int phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public UserRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int id;
	@NotBlank(message = "userName not bank.")
	@Size(max = 45)
	private String userName;
	@Size(max = 45)
	private String email;
	@Size(max = 45)
	private String address;
	@Min(0)
	@Max(2147483647)
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
