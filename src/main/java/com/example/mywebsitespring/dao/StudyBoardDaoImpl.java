package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.StudyBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO : Repository 뜻
@Repository
public class StudyBoardDaoImpl implements StudyBoardDao{

    @Autowired
    private SqlSession session;
//    TODO : 이거 뭔지 모름
    private static String namespace = "com.example.mywebsitespring.dao.studyBoardMapper.";



    @Override
    public StudyBoardDto selectStudyBoard(int bno) {
        return session.selectOne(namespace+"select", bno);
    }

    @Override
    public List<StudyBoardDto> selectStudyBoardPage(int number) {
        return session.selectList(namespace + "selectPage", number);
    }

    @Override
    public List<StudyBoardDto> selectStudyBoardAll() {
        return session.selectList(namespace+"selectAll");
    }

    @Override
    public int insertStudyBoard(StudyBoardDto studyBoardDto) {
        return session.insert(namespace + "insert", studyBoardDto);
    }

    @Override
    public int updateStudyBoard(StudyBoardDto studyBoardDto) {
        return session.update(namespace + "update", studyBoardDto);
    }

    @Override
    public int deleteStudyBoard(int bno) {
        return session.delete(namespace + "delete", bno);
    }

    @Override
    public int deleteStudyBoardAll() {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int countStudyBoard() {
        return session.selectOne(namespace + "countStudyBoard");
    }
}
