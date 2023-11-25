package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.StudyBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudyBoardDaoImpl implements StudyBoardDao {

    @Autowired
    private SqlSession session;
    private static String namespace = "com.example.mywebsitespring.dao.studyBoardMapper.";


    @Override
    public StudyBoardDto selectStudyBoard(int bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

    @Override
    public List<StudyBoardDto> selectStudyBoardPage(int number) throws Exception {
        return session.selectList(namespace + "selectPage", number);
    }

    @Override
    public List<StudyBoardDto> selectStudyBoardAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public int insertStudyBoard(StudyBoardDto studyBoardDto) throws Exception {
        return session.insert(namespace + "insert", studyBoardDto);
    }

    @Override
    public int updateStudyBoard(StudyBoardDto studyBoardDto) throws Exception {
        return session.update(namespace + "update", studyBoardDto);
    }

    @Override
    public int deleteStudyBoard(int bno) throws Exception {
        return session.delete(namespace + "delete", bno);
    }

    @Override
    public int deleteStudyBoardAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int countStudyBoard() throws Exception {
        return session.selectOne(namespace + "countStudyBoard");
    }
}
