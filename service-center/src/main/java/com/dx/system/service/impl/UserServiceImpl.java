package com.dx.system.service.impl;

import com.dx.system.domain.User;
import com.dx.system.mapper.UserMapper;
import com.dx.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by lijin on 2018/4/25.
 */
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List findAll(){
        List<User> list =userMapper.findAll();
        return list;
    }
    @Override
    public List<User> findUserByName(User user1){
       List<User> user=userMapper.findUserByName(user1.getName());
       return user;

    }
}
