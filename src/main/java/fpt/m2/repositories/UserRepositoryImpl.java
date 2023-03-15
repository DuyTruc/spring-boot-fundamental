package fpt.m2.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fpt.m2.entities.UserEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
    private EntityManager em;
	
	
	
	@Override
	@Transactional
	public void createUser(UserEntity user) {
		Query query = em.createNativeQuery(
				  "INSERT INTO user(user_name, email, address, phone_number)"
				  + "values(:user_name, :email, :address, :phone_number)"
				  );
				
				
				query
				  .setParameter("user_name", user.getUserName())
				  .setParameter("email", user.getEmail())
				  .setParameter("address", user.getAddress())
				  .setParameter("phone_number", user.getPhoneNumber()).executeUpdate();
	}

	@Override
	public List<UserEntity> getUserByName(String name) {
		// TODO Auto-generated method stub
		
		Query query = em.createNativeQuery(
				  "SELECT user_name, address, email, phone_number FROM user where user_name Like :name ", UserEntity.class);
				
		List<UserEntity> a = (List<UserEntity>) query.setParameter("name", "%" + name + "%" ).getResultList();
				return a;
	}
	
	@Override
	@Transactional
	public void updateUser(UserEntity user) {
		Query query = em.createNativeQuery(
				  "update user "
				  + "set user_name = :user_name, email = :email, address = :address, phone_number = :phone_number "
				  + "where email = :email"
				  );
				
				
				query
				  .setParameter("user_name", user.getUserName())
				  .setParameter("email", user.getEmail())
				  .setParameter("address", user.getAddress())
				  .setParameter("phone_number", user.getPhoneNumber()).executeUpdate();
				
	}
	
	@Override
	@Transactional
	public void deleteUser(String email) {
		 em.createNativeQuery("delete from user where email = :email").setParameter("email", email).executeUpdate();
				
	}

	@Override
	@Transactional
	public int countUser(String email) {
		return ((Number) em.createNativeQuery(
				  "SELECT count(1) FROM user where email = :email").setParameter("email", email).getSingleResult()).intValue();
	}

}
