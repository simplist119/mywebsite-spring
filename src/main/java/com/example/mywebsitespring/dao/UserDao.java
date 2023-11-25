package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.UserDto;

import java.util.List;

public interface UserDao {

    UserDto selectUser(String id) throws Exception;

    List<UserDto> selectAll() throws Exception;

    int updateUser(UserDto userDto) throws Exception;

    int insertUser(UserDto userDto) throws Exception;

    int deleteUser(String id) throws Exception;

    int deleteAll() throws Exception;
}
