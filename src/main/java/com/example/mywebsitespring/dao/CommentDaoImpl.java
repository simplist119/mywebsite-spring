package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.example.mywebsitespring.dao.commentMapper.";

    @Override
    public int count(int bno) throws Exception {
        return session.selectOne(namespace + "count", bno);
    }

    @Override
    public CommentDto select(int cno) throws Exception {
        return session.selectOne(namespace + "select", cno);
    }

    @Override
    public List<CommentDto> selectAll(int bno) throws Exception {
        return session.selectList(namespace + "selectAll", bno);
    }

    @Override
    public int delete(Map map) throws Exception {
        return session.delete(namespace + "delete", map);
    }

    @Override
    public int deleteAll(int bno) throws Exception {
        return session.delete(namespace + "deleteAll", bno);
    }

    @Override
    public int update(CommentDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    @Override
    public int insert(CommentDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }
}
