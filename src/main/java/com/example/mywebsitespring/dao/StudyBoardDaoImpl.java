package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.StudyBoardDto;

import java.util.List;

public class StudyBoardDaoImpl implements StudyBoardDao{

    @Override
    public StudyBoardDto selectStudyBoard(String bno) {
        return null;
    }

    @Override
    public List<StudyBoardDto> selectStudyBoards() {
        return null;
    }

    @Override
    public int insertStudyBoard(StudyBoardDto studyBoardDto) {
        return 0;
    }

    @Override
    public int updateStudyBoard(StudyBoardDto studyBoardDto) {
        return 0;
    }

    @Override
    public int deleteStudyBoard(String bno) {
        return 0;
    }

    @Override
    public int deleteStudyBoardAll() {
        return 0;
    }
}
