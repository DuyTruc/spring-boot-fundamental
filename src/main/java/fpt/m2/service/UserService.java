package fpt.m2.service;

import fpt.m2.entity.UserEntity;

public interface UserService {

	UserEntity findById(long id);

	void saveUser(UserEntity userEntity);

	void deleteUser(long id);

}
