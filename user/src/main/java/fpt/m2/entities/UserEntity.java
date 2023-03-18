package fpt.m2.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@JsonProperty("id")
	private int id;

	@NotNull
	@JsonProperty("user_name")
	private String userName;
	
	@Email
	@JsonProperty("email")
	private String email;
	
	@NotNull
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("phone_number")
	@Size(min= 1, max = 1_999_999_999)
	private int phoneNumber;
}
