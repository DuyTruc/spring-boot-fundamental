package fpt.m2.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fpt.m2.entity.UserEntity;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public <S extends UserEntity> S save(S entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public void deleteById(Integer id) {
		String hql = "DELETE FROM UserEntity WHERE id = :id";
		entityManager.createQuery(hql).setParameter("id", id).executeUpdate();
	}

	@Override
	public UserEntity getUserById(Integer id) {
		String hql = "FROM UserEntity WHERE id = :id";
		return entityManager.createQuery(hql, UserEntity.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<UserEntity> findAll() {
		TypedQuery<UserEntity> query = entityManager.createQuery("SELECT u FROM UserEntity u", UserEntity.class);
		return query.getResultList();
	}

	@Override
	public UserEntity updateUser(Integer id, UserEntity user) {
		String hql = "UPDATE UserEntity SET user_name = :user_name, email = :email, address = :address, phone_number = :phone_number WHERE id = :id";
		Query query = entityManager.createQuery(hql);
		query.setParameter("user_name", user.getUserName());
		query.setParameter("email", user.getEmail());
		query.setParameter("address", user.getAddress());
		query.setParameter("phone_number", user.getPhoneNumber());
		query.setParameter("id", id);
		query.executeUpdate();
		entityManager.flush();

		return entityManager.find(UserEntity.class, id);
	}

	@Override
	public List<UserEntity> findAll(Sort sort) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends UserEntity> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<UserEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public UserEntity getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity getReferenceById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<UserEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(UserEntity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends UserEntity> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends UserEntity> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends UserEntity> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends UserEntity, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public UserEntity getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
