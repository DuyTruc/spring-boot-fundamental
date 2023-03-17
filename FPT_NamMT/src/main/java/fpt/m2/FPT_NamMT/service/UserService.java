package fpt.m2.FPT_NamMT.service;

import fpt.m2.FPT_NamMT.model.UserEntity;

import java.util.List;

public interface UserService {
  void createUser(UserEntity user);

  List<UserEntity> getAllUser();

  List<UserEntity> getUserByName(String name);

  UserEntity getUserById(String id);

  void updateUser(UserEntity user);

  void deleteUser(UserEntity user);
}
