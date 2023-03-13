package fpt.m2.tantcd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    String userName;

    String email;

    String address;

    int phoneNumber;
}
