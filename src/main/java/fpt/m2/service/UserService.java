package fpt.m2.service;

import fpt.m2.entity.UserEntity;

public interface UserService {

    UserEntity createUser(UserEntity user);

    UserEntity getUserByName(String userName);

    UserEntity updateUser(UserEntity user);

    void deleteUser(Long id);
}
