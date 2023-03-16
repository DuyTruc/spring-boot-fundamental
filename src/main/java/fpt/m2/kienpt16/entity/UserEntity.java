package fpt.m2.kienpt16.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    @NotNull
    @Size(min = 2, max = 100, message = "{Nhap Ten}")
    private String userName;

    @Email(message = "Nhap Dung Email Ex:@gmail.com")
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Size(min = 11, max = 11, message = "{Nhap SDT}")
    @Column(name = "phone_number")
    private String phoneNumber;
}
