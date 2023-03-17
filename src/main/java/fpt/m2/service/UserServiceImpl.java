package fpt.m2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.entity.UserEntity;
import fpt.m2.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity findById(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void saveUser(UserEntity userEntity) {
		userRepository.save(userEntity);

	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);

	}
}
