package fpt.m2.ThienNLNT.services;

import java.util.List;
import java.util.Optional;

import fpt.m2.ThienNLNT.entities.UserEntity;

public interface UserService {
    List<UserEntity> findAll();
    Optional<UserEntity> getById(int id);
    UserEntity saveEntity(UserEntity userEntity);
    void deleteById(int id);
    UserEntity updateUserEntity(UserEntity userEntity);
    List<UserEntity> findAllByUserName(String username);
}
