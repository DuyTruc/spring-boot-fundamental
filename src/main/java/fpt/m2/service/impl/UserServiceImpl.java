package fpt.m2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.entity.UserEntity;
import fpt.m2.repository.UserRepository;
import fpt.m2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
