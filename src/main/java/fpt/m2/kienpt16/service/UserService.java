package fpt.m2.kienpt16.service;

import fpt.m2.kienpt16.entity.UserEntity;

import java.util.List;

public interface UserService {

    void createUser(UserEntity user);

    List<UserEntity> getUserByName(String name);

    void updateUser(UserEntity user);

    void deleteUser(int userId);
}
