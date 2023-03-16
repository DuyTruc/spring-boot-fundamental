package fpt.m2.FPT_DucNN19.services;

import fpt.m2.FPT_DucNN19.entity.UserEntity;

public interface UserService {

  void createUserService(UserEntity userEntity);

  UserEntity getUserService(Long id);

  void updateUserService(Long id, UserEntity userEntity);

  void deleteUserService(Long id);

}
