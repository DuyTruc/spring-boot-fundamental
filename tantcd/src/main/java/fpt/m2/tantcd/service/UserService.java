package fpt.m2.tantcd.service;

import fpt.m2.tantcd.entity.User;

public interface UserService {
    void create(User user);

    User getByName(String userName);

    void update(User user);

    void delete(String userName);
}
