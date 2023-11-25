package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.CommentDto;

import java.util.List;
import java.util.Map;

public interface CommentDao {

    int count(int bno) throws Exception;

    CommentDto select(int cno) throws Exception;

    List<CommentDto> selectAll(int bno) throws Exception;

    int delete(Map map) throws Exception;

    int deleteAll(int bno) throws Exception;

    int update(CommentDto dto) throws Exception;

    int insert(CommentDto dto) throws Exception;
}
