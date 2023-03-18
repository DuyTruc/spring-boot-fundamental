package fpt.m2.tantcd.service;

import fpt.m2.tantcd.entity.User;

public interface UserService {
    void create(User user);

    User getById(int id);

    void update(User user);

    void delete(int id);
}
