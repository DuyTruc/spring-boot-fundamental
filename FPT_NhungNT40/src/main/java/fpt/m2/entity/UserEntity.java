package fpt.m2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "User name not be blank!")
	private String userName;

	@NotBlank(message = "Email not be blank!")
	@Email(message = "Email is not valid!")
	private String email;

	@NotBlank(message = "Address not be blank!")
	private String address;

	@NotNull(message = "Phone number not be null!")
	private int phoneNumber;
}
