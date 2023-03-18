package fpt.m2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.entities.UserEntity;
import fpt.m2.repositories.UserRepository;
import fpt.m2.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity usr) {
		return userRepository.save(usr);
	}

	@Override
	public UserEntity getUserById(int id) {
		if (userRepository.findById(id) != null) {
			return userRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public UserEntity updateUser(UserEntity usr) {
		return userRepository.save(usr);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
}
