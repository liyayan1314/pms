package com.dx.system.service;

import com.dx.system.domain.User;

import java.util.List;

/**
 * Created by lijin on 2018/4/25.
 */
public interface UserService {
    public List<User> findAll();
    public List<User> findUserByName(User user);
}
