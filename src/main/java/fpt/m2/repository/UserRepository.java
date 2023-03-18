package fpt.m2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import fpt.m2.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	UserEntity findByUserName(String userName);
}
