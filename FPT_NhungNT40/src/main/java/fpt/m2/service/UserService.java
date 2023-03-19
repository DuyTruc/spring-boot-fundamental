package fpt.m2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fpt.m2.entity.UserEntity;

@Service
public interface UserService {
	UserEntity createUser(UserEntity user);

	void deleteUser(Integer id);

	UserEntity getUserById(Integer id);

	List<UserEntity> getAllUsers();

	UserEntity updateUser(Integer id, UserEntity user);
}
