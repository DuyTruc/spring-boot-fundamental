package fpt.m2.repositories;

import java.util.List;

import fpt.m2.entities.UserEntity;

public interface UserRepository {
	
	void createUser(UserEntity user);
	
	List<UserEntity> getUserByName(String name);
	
	void updateUser(UserEntity user);
	
	void deleteUser(String email);
	
	int countUser(String email); 
}
