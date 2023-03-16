package fpt.m2.FPT_DucNN19.services.imp;

import fpt.m2.FPT_DucNN19.entity.UserEntity;
import fpt.m2.FPT_DucNN19.repository.UserRepository;
import fpt.m2.FPT_DucNN19.services.UserService;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * The type User service.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository userRepository;
  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public void createUserService(UserEntity userEntity) {
    userRepository.save(userEntity);
  }

  @Override
  public UserEntity getUserService(Long id) {
    Optional<UserEntity> user = userRepository.findById(id);
    if (user.isPresent()) {
      return user.get();
    } else {
      LOGGER.debug("Not found");
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    }
  }

  @Override
  public void updateUserService(Long id, UserEntity userEntity) {
    Optional<UserEntity> user = userRepository.findById(id);
    if (user.isPresent()) {
      userEntity.setId(Math.toIntExact(id));
      userRepository.save(userEntity);
    } else {
      LOGGER.debug("Not found");
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    }
  }

  @Override
  public void deleteUserService(Long id) {
    Optional<UserEntity> user = userRepository.findById(id);
    if (user.isPresent()) {
      userRepository.deleteById(id);
    } else {
      LOGGER.debug("Not found");
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    }
  }
}
