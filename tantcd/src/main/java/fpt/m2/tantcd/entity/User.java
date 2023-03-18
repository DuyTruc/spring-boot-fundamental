package fpt.m2.tantcd.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotEmpty(message = "User name cannot be blank")
    String userName;

    @NotEmpty
    String email;

    @NotEmpty
    String address;

    @NotNull
    int phoneNumber;
}
