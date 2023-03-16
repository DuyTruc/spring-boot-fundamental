package fpt.m2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.common.exception.BusinessException;
import fpt.m2.entities.UserEntity;
import fpt.m2.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void createUser(UserEntity user) {
		int userExsits = userRepository.countUser(user.getEmail());
		if (userExsits > 0) {
			throw new BusinessException("1");
		}
		userRepository.createUser(user);
	}

	@Override
	public List<UserEntity> getUserByName(String name) {
		List<UserEntity> user = userRepository.getUserByName(name);
		return user;
	}

	@Override
	public void updateUser(UserEntity user) {
		int userExsits = userRepository.countUser(user.getEmail());
		if (userExsits == 0) {
			throw new BusinessException();
		}
		userRepository.updateUser(user);
		
	}

	@Override
	public void deleteUser(String email) {
		int userExsits = userRepository.countUser(email);
		if (userExsits == 0) {
			throw new BusinessException();
		}
		userRepository.deleteUser(email);
		
	}
	
}
