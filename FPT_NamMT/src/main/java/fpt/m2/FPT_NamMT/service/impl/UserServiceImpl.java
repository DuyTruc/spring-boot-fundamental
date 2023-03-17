package fpt.m2.FPT_NamMT.service.impl;

import fpt.m2.FPT_NamMT.model.UserEntity;
import fpt.m2.FPT_NamMT.repository.UserRepository;
import fpt.m2.FPT_NamMT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public void createUser(UserEntity user) {
    userRepository.save(user);
  }

  @Override
  public List<UserEntity> getAllUser() {
    return userRepository.findAll();
  }

  @Override
  public List<UserEntity> getUserByName(String name) {
    return userRepository.getUserByName(name);
  }

  @Override
  public UserEntity getUserById(String id) {
    return userRepository.findById(id).get();
  }

  @Override
  public void updateUser(UserEntity user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(UserEntity user) {
    userRepository.delete(user);
  }
}
