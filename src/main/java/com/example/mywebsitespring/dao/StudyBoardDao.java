package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.StudyBoardDto;

import java.util.List;

public interface StudyBoardDao {

    int countStudyBoard() throws Exception;

    StudyBoardDto selectStudyBoard(int bno) throws Exception;

    List<StudyBoardDto> selectStudyBoardPage(int number) throws Exception;

    List<StudyBoardDto> selectStudyBoardAll() throws Exception;

    int insertStudyBoard(StudyBoardDto studyBoardDto) throws Exception;

    int updateStudyBoard(StudyBoardDto studyBoardDto) throws Exception;

    int deleteStudyBoard(int bno) throws Exception;

    int deleteStudyBoardAll() throws Exception;
}
