package fpt.m2.tantcd.service.impl;

import fpt.m2.tantcd.entity.User;
import fpt.m2.tantcd.repository.UserRepository;
import fpt.m2.tantcd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public void create(User user) {
        repository.save(user);
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
