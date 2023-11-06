package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.User;
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
    public User selectUser(String id) {
        return session.selectOne(namespace+"select", id);
    }

    @Override
    public List<User> selectAll() {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int updateUser(User user) {
        return session.update(namespace + "update", user);
    }

    @Override
    public int insertUser(User user) {
        return session.insert(namespace + "insert", user);
    }

    @Override
    public int deleteUser(String id) {
        return session.delete(namespace + "delete", id);
    }

    @Override
    public int deleteAll() {
        return session.delete(namespace + "deleteAll");
    }
}
