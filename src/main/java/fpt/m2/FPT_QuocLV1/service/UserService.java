package fpt.m2.FPT_QuocLV1.service;
import fpt.m2.FPT_QuocLV1.dto.UserDto;
import fpt.m2.FPT_QuocLV1.entity.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(long id);
    void updateUser(long id,UserDto userDto);
    void deleteUser(long id);
}
