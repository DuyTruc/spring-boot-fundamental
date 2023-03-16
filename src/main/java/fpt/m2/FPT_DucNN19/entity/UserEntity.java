package fpt.m2.FPT_DucNN19.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "user_entity")
public class UserEntity {

  @Id
  private int id;

  @NotBlank
  @JsonProperty("user_name")
  @Size(max = 100)
  private String userName;

  @NotBlank
  @Email
  @Size(max = 100)
  private String email;

  @NotBlank
  @Size(max = 100)
  private String address;

  @JsonProperty("phone_number")
  private int phoneNumber;

}
