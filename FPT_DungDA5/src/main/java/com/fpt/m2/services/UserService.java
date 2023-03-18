package com.fpt.m2.services;

import com.fpt.m2.dto.UserRequestDTO;
import com.fpt.m2.dto.UserResponseDTO;

public interface UserService {
	// insert user
	UserResponseDTO createUser(UserRequestDTO userRequestDTO);

	// find user by id
	UserResponseDTO getUserById(int id);

	// update user
	UserResponseDTO updateUser(UserRequestDTO userRequestDTO);

	// delete user
	void deleteUser(int id);

}
