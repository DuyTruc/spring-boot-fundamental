package fpt.m2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.m2.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
