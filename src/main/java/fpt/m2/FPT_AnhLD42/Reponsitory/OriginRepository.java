package fpt.m2.FPT_AnhLD42.Reponsitory;

import org.springframework.data.repository.CrudRepository;

import fpt.m2.FPT_AnhLD42.Entity.UserEntity;

public interface OriginRepository extends CrudRepository<UserEntity, Integer> {
}