package fpt.m2.FPT_AnhLD42.Reponsitory;

import java.util.List;

import fpt.m2.FPT_AnhLD42.Entity.UserEntity;

public interface UserRepository {
	public List<UserEntity> findAll();
	public UserEntity getUserById(int id);
	boolean createUser(UserEntity user);
	public UserEntity updateUser(UserEntity user);
    boolean deleteUser(int id);
}