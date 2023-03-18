package fpt.m2.ThienNLNT.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
    private int userId;
	
	@NotNull(message = "Username cannot be null")
	@NotBlank(message = "Username cannot be blank")
	@Column(name = "user_name")
    private String userName;

	@NotNull(message = "Email cannot be null")
	@NotBlank(message = "Email cannot be blank")
	@Email
	@Column(name = "email")
    private String email;
	
	@NotNull(message = "Address cannot be null")
	@Column(name = "address")
    private String address;
	
	@NotNull(message = "Phone number cannot be null")
	@Column(name = "phone_number")
    private int phoneNumber;
    
}
