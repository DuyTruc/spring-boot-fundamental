package fpt.m2.ThienNLNT.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fpt.m2.ThienNLNT.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    UserEntity findByUserName(String username);
    List<UserEntity> findAllByUserName(String userName);
}
