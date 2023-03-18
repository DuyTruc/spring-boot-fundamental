package fpt.m2.FPT_AnhLD42.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpt.m2.FPT_AnhLD42.Entity.UserEntity;
import fpt.m2.FPT_AnhLD42.Reponsitory.UserRepository;
import fpt.m2.FPT_AnhLD42.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userReponsitory;
	
	@Override
	public List<UserEntity> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = userReponsitory.findAll();   
		return users;  
	}
	
	@Override
	public UserEntity getUserById(int id) {
		UserEntity obj = userReponsitory.getUserById(id);
		return obj;
	}

	@Override
	public boolean createUser(UserEntity user) {
		// TODO Auto-generated method stub
        userReponsitory.createUser(user);
        return true;
	}

	@Override
	public UserEntity updateUser(UserEntity user) {
		// TODO Auto-generated method stub
	 	return userReponsitory.updateUser(user);
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		userReponsitory.deleteUser(id);
		return true;
	}

}
