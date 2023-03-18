package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	// Save operation
	@Override
	public UserEntity saveUser(UserEntity User) {
		return userRepository.save(User);
	}

	// Read operation
	@Override
	public List<UserEntity> fetchUserList() {
		return (List<UserEntity>) userRepository.findAll();
	}
	
	@Override
	public UserEntity fetchUser(Integer id) {
		return userRepository.findById(id).get();
	}

	// Update operation
	@Override
	public UserEntity updateUser(UserEntity user, Integer id) {

		UserEntity depDB = userRepository.findById(id).get();
		return userRepository.save(depDB);
	}

	// Delete operation
	@Override
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
}
