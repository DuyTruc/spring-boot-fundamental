package fpt.m2.FPT_HoangDQ2.service;

import fpt.m2.FPT_HoangDQ2.model.User;
import fpt.m2.FPT_HoangDQ2.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) throws Exception{
        return userRepository.findById(id).orElseThrow(()-> new Exception("User with id "+id+" not found"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
