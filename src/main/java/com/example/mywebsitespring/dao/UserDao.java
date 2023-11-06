package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.User;

import java.util.List;

public interface UserDao {

    User selectUser(String id);

    List<User> selectAll();

    int updateUser(User user);

    int insertUser(User user);

    int deleteUser(String id);

    int deleteAll();
}
