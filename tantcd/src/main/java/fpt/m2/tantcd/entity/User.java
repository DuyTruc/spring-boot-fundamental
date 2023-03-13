package fpt.m2.tantcd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @NotEmpty(message = "User name cannot be blank")
    String userName;

    @NotEmpty
    String email;

    @NotEmpty
    String address;

    @NotNull
    int phoneNumber;
}
