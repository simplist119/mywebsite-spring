package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.StudyBoardDto;

import java.util.List;

public interface StudyBoardDao {

    int countStudyBoard();

    StudyBoardDto selectStudyBoard(int bno);

    List<StudyBoardDto> selectStudyBoardPage(int number);

    List<StudyBoardDto> selectStudyBoardAll();

    int insertStudyBoard(StudyBoardDto studyBoardDto);

    int updateStudyBoard(StudyBoardDto studyBoardDto);

    int deleteStudyBoard(int bno);

    int deleteStudyBoardAll();
}
