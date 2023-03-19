package fpt.m2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.m2.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity updateUser(Integer id, UserEntity user);

	UserEntity getUserById(Integer id);

}