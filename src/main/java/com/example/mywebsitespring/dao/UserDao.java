package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.UserDto;

import java.util.List;

public interface UserDao {

    UserDto selectUser(String id);

    List<UserDto> selectAll();

    int updateUser(UserDto userDto);

    int insertUser(UserDto userDto);

    int deleteUser(String id);

    int deleteAll();
}
