package fpt.m2.FPT_AnhLD42.Reponsitory.ReponsitoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fpt.m2.FPT_AnhLD42.Entity.UserEntity;
import fpt.m2.FPT_AnhLD42.Reponsitory.OriginRepository;
import fpt.m2.FPT_AnhLD42.Reponsitory.UserRepository;

@Repository
public class UserReponsitoryImpl implements UserRepository {
	
	@Autowired
	private OriginRepository originRepo;
	
	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<UserEntity>) originRepo.findAll();
	}

	@Override
	public UserEntity getUserById(int id) {
		Optional<UserEntity> userResponse =  originRepo.findById(id);
		UserEntity user = userResponse.get();
		return user;
	}

	@Override
	public boolean createUser(UserEntity user) {
		// TODO Auto-generated method stub
		originRepo.save(user);
		return true;
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		// TODO Auto-generated method stub
		UserEntity updateResponse = originRepo.save(user);
        return updateResponse;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		originRepo.deleteById(id);
		return true;
	}


}
