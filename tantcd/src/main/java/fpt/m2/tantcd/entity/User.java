package fpt.m2.tantcd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NonNull;
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

    @NonNull
    int phoneNumber;
}
