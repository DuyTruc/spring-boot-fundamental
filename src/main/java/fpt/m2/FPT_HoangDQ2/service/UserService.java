package fpt.m2.FPT_HoangDQ2.service;

import fpt.m2.FPT_HoangDQ2.model.User;


public interface UserService {
    User create(User user);

    User save(User user);

    User findById(Long id) throws Exception;

    void deleteById(Long id);
}
