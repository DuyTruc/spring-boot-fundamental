package fpt.m2.kienpt16.repository;

import fpt.m2.kienpt16.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "SELECT *\n" +
            "FROM user as u\n" +
            "WHERE u.user_name = ?1", nativeQuery = true)
    List<UserEntity> findUserByName(String name);
}
