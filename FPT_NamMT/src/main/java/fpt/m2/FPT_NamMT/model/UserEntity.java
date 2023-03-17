package fpt.m2.FPT_NamMT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Table(name = "user_entity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid")
  @Column(columnDefinition = "CHAR(32)")
  private String id;

  @Column(name = "user_name")
  @NotEmpty(message = "{validate.username_empty}")
  @Pattern(regexp = "^[A-Za-z]+$", message = "{validate.username_invalid}")
  private String userName;


  @Email(message = "{validate.email}")
  @NotEmpty(message = "{validate.email_empty}")
  private String email;

  @NotEmpty(message = "{validate.address_empty}")
  private String address;

  @NotNull(message = "{validate.phone_format}")
  private Integer phoneNumber;
}
