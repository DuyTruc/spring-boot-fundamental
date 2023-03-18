package fpt.m2.FPT_QuocLV1.service;

import fpt.m2.FPT_QuocLV1.dto.UserDto;
import fpt.m2.FPT_QuocLV1.entity.UserEntity;
import fpt.m2.FPT_QuocLV1.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
    UserEntity userEntity = ConvertUserDtoToUserEntity(userDto);
    userEntity = userRepository.save(userEntity);
        return ConvertUserEntityToUserDto(userEntity);
    }

    private UserDto ConvertUserEntityToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity,userDto);
        return userDto;
    }

    private UserEntity ConvertUserDtoToUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto,userEntity);
        return userEntity;
    }

    @Override
    public UserDto getUserById(long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            return ConvertUserEntityToUserDto(optionalUserEntity.get());
        }
        else {
            throw new NullPointerException();
        }
    }

    @Override
    public void updateUser(long id,UserDto userDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            optionalUserEntity.get().setUserName(userDto.getUserName());
            optionalUserEntity.get().setEmail(userDto.getEmail());
            optionalUserEntity.get().setAddress(userDto.getAddress());
            optionalUserEntity.get().setPhoneNumber(userDto.getPhoneNumber());
            userRepository.save(optionalUserEntity.get());
        }
        else{
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteUser(long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if(optionalUserEntity.isPresent()){
            userRepository.delete(optionalUserEntity.get());
        }
        else {
            throw new NullPointerException();
        }
    }
}
