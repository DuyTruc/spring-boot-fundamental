package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserService {
	// Save operation
	UserEntity saveUser(UserEntity userEntity);
 
    // Read operation
    List<UserEntity> fetchUserList();
    
	UserEntity fetchUser(Integer id);
 
    // Update operation
    UserEntity updateUser(UserEntity userEntity,
                                Integer id);
 
    // Delete operation
    void deleteUserById(Integer id);

}
