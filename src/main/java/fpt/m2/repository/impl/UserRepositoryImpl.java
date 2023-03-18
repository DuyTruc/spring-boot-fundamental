package fpt.m2.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import fpt.m2.entity.UserEntity;
import fpt.m2.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

	@Autowired
	private EntityManager entityManager;

	public UserEntity findByUserName(String userName) {
	    String sql = "SELECT * FROM user WHERE username = ?";
	    Query query = entityManager.createNativeQuery(sql, UserEntity.class);
	    query.setParameter(1, userName);
	    List<UserEntity> users = query.getResultList();
	    return users.isEmpty() ? null : users.get(0);
	}
}
