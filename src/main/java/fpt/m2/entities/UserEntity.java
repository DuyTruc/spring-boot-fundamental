package fpt.m2.entities;

import fpt.m2.common.constants.MessageConstant;
import fpt.m2.common.validation.constraint.Email;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
	
	@Id
	@NotNull(message = MessageConstant.V5)
	@Email(message = MessageConstant.V4)
	private String email;

	@NotNull(message = MessageConstant.V1)
	private String userName;

	@NotNull(message = MessageConstant.V2)
	private String address;

	@NotNull(message = MessageConstant.V3)
	private String phoneNumber;
}
