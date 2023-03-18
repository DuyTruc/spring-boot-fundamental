package fpt.m2.kienpt16.service.impl;

import fpt.m2.kienpt16.entity.UserEntity;
import fpt.m2.kienpt16.repository.UserRepository;
import fpt.m2.kienpt16.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserEntity user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setEmail(user.getEmail());
        userEntity.setAddress(user.getAddress());
        userEntity.setPhoneNumber(user.getPhoneNumber());

        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getUserByName(String name) {
        List<UserEntity> user = userRepository.findUserByName(name);
        return user;
    }

    @Override
    public void updateUser(UserEntity user) {

        int userId = user.getId();

        Optional users = userRepository.findById(userId);

        if(!users.isPresent()){
            LOGGER.debug("Not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }

        userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {

        Optional users = userRepository.findById(userId);

        if(!users.isPresent()){
            LOGGER.debug("Not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }

        userRepository.deleteById(userId);
    }
}
