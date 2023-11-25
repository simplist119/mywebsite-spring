package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.example.mywebsitespring.dao.userMapper.";

    @Override
    public UserDto selectUser(String id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }

    @Override
    public List<UserDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public int updateUser(UserDto userDto) throws Exception {
        return session.update(namespace + "update", userDto);
    }

    @Override
    public int insertUser(UserDto userDto) throws Exception {
        return session.insert(namespace + "insert", userDto);
    }

    @Override
    public int deleteUser(String id) throws Exception {
        return session.delete(namespace + "delete", id);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
