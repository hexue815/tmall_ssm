package com.xue.service;

import com.xue.pojo.User;

import java.util.List;

public interface UserService {
    int add(User user);

    int delete(int id);

    int update(User user);

    User get(int id);

    List<User> list();
}
