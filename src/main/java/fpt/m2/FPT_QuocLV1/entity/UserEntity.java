package fpt.m2.FPT_QuocLV1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private long id;
    @NotBlank
    private String userName;
    @NotBlank(message = "Email not blank")
    @Email
    private String email;
    @NotBlank(message = "Address not blank")
    private String address;
    @NumberFormat
    private int phoneNumber;

}
