package fpt.m2.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String userName;
	
	@Email
	private String email;
	
	@NotNull
	private int address;
	
	@Size(min= 1, max = 1_999_999_999)
	public int phoneNumber;
}
