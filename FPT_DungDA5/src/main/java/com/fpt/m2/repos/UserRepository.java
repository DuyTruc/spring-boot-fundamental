package com.fpt.m2.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fpt.m2.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
