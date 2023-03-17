package fpt.m2.services;

import fpt.m2.entities.UserEntity;

public interface UserService {
	UserEntity createUser(UserEntity usr);
	
	UserEntity getUserById(int id);
	
	UserEntity updateUser(UserEntity usr);
	
	void deleteUser(int id);
}
