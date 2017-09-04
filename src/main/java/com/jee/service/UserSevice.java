package com.jee.service;


import com.jee.po.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSevice {
    public User getUser(String name);
    public int insertUser(User user);
    public int updateUser(User user);
    public User getUserFromId(int id);
}
