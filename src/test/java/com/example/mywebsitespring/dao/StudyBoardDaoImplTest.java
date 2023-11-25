package com.example.mywebsitespring.dao;


import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import com.example.mywebsitespring.domain.StudyBoardDto;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class StudyBoardDaoImplTest {

    @Autowired
    StudyBoardDao studyBoardDao;

    @Test
    public void selectPagetest() throws Exception {
        System.out.println("1111");
        int count = studyBoardDao.countStudyBoard();
        System.out.println("count = " + count);
        List<StudyBoardDto> list = null;
        list = studyBoardDao.selectStudyBoardPage(count);
        System.out.println("list = " + list);
        assertTrue(list != null);
    }

    @Test
    public void selectStudyBoard() throws Exception {
        int bno = 0;
    }

    @Test
    public void selectStudyBoardAll() throws Exception {
        System.out.println("1111");
        List<StudyBoardDto> list = null;
        list = studyBoardDao.selectStudyBoardAll();
        System.out.println(list);
        assertTrue(list != null);
    }


    @Test
    public void countStudyBoard() throws Exception {
        int i = 0;
        i = studyBoardDao.countStudyBoard();
        System.out.println(i);
        assertTrue(i >= 0);
    }

    @Test
    public void insertStudyBoard() throws Exception {
//        TODO : BNO 자동으로 입력하기 구현
        int result = 0;
        for (int i = 1; i <= 50; i++) {
            StudyBoardDto dto = new StudyBoardDto(i, "제목" + i, "내용" + i, "작성자" + i, 0, 1, new Date());
            result = studyBoardDao.insertStudyBoard(dto);
            System.out.println("result = " + result);
        }
//        StudyBoardDto dto2 = new StudyBoardDto();
//        dto2.setBno(20);
//        dto2.setTitle("asdf");
//        dto2.setContent("qwer");
//        dto2.setWriter("111");
//        dto2.setReg_date(new Date());
//        dto2.setView_cnt(0);
//        dto2.setComment_cnt(3);
        System.out.println("result = " + result);
        assertTrue(result > 0);
    }

    @Test
    public void updateStudyBoard() throws Exception {
    }

    @Test
    public void countStudyBoardtest() throws Exception {
        int result = 0;
        result = studyBoardDao.countStudyBoard();
        System.out.println("result = " + result);
        assertTrue(result >= 0);

    }

    @Test
    public void deleteStudyBoardtest() throws Exception {
        int result = 0;
        result = studyBoardDao.deleteStudyBoard(32);
        System.out.println("result = " + result);
        assertTrue(result > 0);
    }

    @Test
    public void deleteStudyBoardAlltest() throws Exception {
        int result = 0;
        result = studyBoardDao.deleteStudyBoardAll();
        assertTrue(result > 0);
    }
}