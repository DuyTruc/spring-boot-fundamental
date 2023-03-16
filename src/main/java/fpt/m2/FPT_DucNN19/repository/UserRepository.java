package fpt.m2.FPT_DucNN19.repository;

import fpt.m2.FPT_DucNN19.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}