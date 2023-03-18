package fpt.m2.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@JsonProperty("userName")
	@NotBlank(message = "userName must not be blank")
	@Size(max = 50)
	@Column(name = "username")
	private String userName;

	@JsonProperty("email")
	@NotBlank(message = "email must not be blank")
	@Size(max = 50)
	@Column(name = "email")
	private String email;

	@JsonProperty("address")
	@NotBlank(message = "address must not be blank")
	@Size(max = 100)
	@Column(name = "address")
	private String address;

	@JsonProperty("phoneNumber")
	@NotBlank(message = "phoneNumber must not be blank")
	@Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "invalid phone number")
	@Column(name = "phonenumber")
	private String phoneNumber;

	public UserEntity() {
	}

	public UserEntity(String userName, String email, String address, String phoneNumber) {
		this.userName = userName;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
