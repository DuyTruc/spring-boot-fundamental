package fpt.m2.ThienNLNT.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.ThienNLNT.dao.UserRepository;
import fpt.m2.ThienNLNT.entities.UserEntity;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository  userRepository;
    
    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity saveEntity(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUserEntity(UserEntity UserEntity) {
    	UserEntity existingUserEntity = userRepository.findById(UserEntity.getUserId()).orElse(null);
        existingUserEntity.setUserName(UserEntity.getUserName());
        existingUserEntity.setEmail(UserEntity.getEmail());
        existingUserEntity.setAddress(UserEntity.getAddress());
        existingUserEntity.setPhoneNumber(UserEntity.getPhoneNumber());
        return userRepository.save(existingUserEntity);
    }

	@Override
	public List<UserEntity> findAllByUserName(String username) {
		return userRepository.findAllByUserName(username);
	}
}
