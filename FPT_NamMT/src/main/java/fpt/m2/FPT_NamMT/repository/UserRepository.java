package fpt.m2.FPT_NamMT.repository;

import fpt.m2.FPT_NamMT.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
  @Query(value = "SELECT * FROM user_entity WHERE user_name LIKE %:userName%", nativeQuery = true)
  List<UserEntity> getUserByName(@Param("userName") String userName);
}
