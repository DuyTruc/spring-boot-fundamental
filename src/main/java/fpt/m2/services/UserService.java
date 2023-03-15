package fpt.m2.services;

import java.util.List;

import fpt.m2.entities.UserEntity;

public interface UserService {
	void createUser(UserEntity user);
	
	List<UserEntity> getUserByName(String name);
	
	void updateUser(UserEntity user);
	
	void deleteUser(String email);
}
