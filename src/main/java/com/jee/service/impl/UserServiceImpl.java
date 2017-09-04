package com.jee.service.impl;

import com.jee.mapper.UserMapper;
import com.jee.po.User;
import com.jee.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserSevice{
    @Autowired
    private UserMapper userMapper;
    public User getUser(String name) {
        return userMapper.getUser(name);
    }

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public User getUserFromId(int id) {
        return userMapper.getUserFromId(id);
    }

}
