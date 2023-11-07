package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.StudyBoardDto;

import java.util.List;

public interface StudyBoardDao {

    StudyBoardDto selectStudyBoard(String bno);

    List<StudyBoardDto> selectStudyBoards();

    int insertStudyBoard(StudyBoardDto studyBoardDto);

    int updateStudyBoard(StudyBoardDto studyBoardDto);

    int deleteStudyBoard(String bno);

    int deleteStudyBoardAll();
}
