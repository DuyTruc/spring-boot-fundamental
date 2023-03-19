package fpt.m2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.entity.UserEntity;
import fpt.m2.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity user) {
		return userRepository.save(user);
	}

	@Override
	public UserEntity getUserById(Integer id) {
		return userRepository.getUserById(id);
	}

	@Override
	public UserEntity updateUser(Integer id, UserEntity user) {
		return userRepository.updateUser(id, user);
	}

	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

}
