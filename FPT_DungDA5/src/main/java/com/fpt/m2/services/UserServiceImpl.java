package com.fpt.m2.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.m2.dto.UserRequestDTO;
import com.fpt.m2.dto.UserResponseDTO;
import com.fpt.m2.entities.UserEntity;
import com.fpt.m2.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	ModelMapper mapper = new ModelMapper();
	UserResponseDTO userResponseDTO = new UserResponseDTO();
	UserEntity userEntity = new UserEntity();

	@Override
	public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
		// convert data input from dto to entity
		userEntity = mapper.map(userRequestDTO, UserEntity.class);
		userEntity = userRepository.save(userEntity);
		// convert data response and return
		userResponseDTO = mapper.map(userEntity, UserResponseDTO.class);
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO getUserById(int id) {
		userEntity = userRepository.findById(id).get();
		// convert data response and return
		userResponseDTO = mapper.map(userEntity, UserResponseDTO.class);
		return userResponseDTO;
	}

	@Override
	public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
		// convert data input from dto to entity
		userEntity = mapper.map(userRequestDTO, UserEntity.class);
		userEntity = userRepository.save(userEntity);
		// convert data response and return
		userResponseDTO = mapper.map(userEntity, UserResponseDTO.class);
		return userResponseDTO;
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
