package com.example.mywebsitespring.controller;

import com.example.mywebsitespring.dao.StudyBoardDao;
import com.example.mywebsitespring.domain.StudyBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController2 {

    @Autowired
    StudyBoardDao studyBoardDao;

    //보드리스트 띄워줌
    @GetMapping("/study")
    public String board3(int bno, Model model) {
        try {
            StudyBoardDto studyBoardDto = null;
            studyBoardDto = studyBoardDao.selectStudyBoard(bno);
            if (studyBoardDto != null) {
                studyBoardDto.setView_cnt(studyBoardDto.getView_cnt() + 1);
                studyBoardDao.updateStudyBoard(studyBoardDto);
            }
            model.addAttribute("board", studyBoardDto);
            return "studyBoard";
        } catch (Exception e) {
            return "index";
        }
    }

    @GetMapping("/study/list")
    public String board1(int page, Model model) throws Exception {
        int count = studyBoardDao.countStudyBoard();
        System.out.println("count = " + count);
        int numberofpages = count % 10 == 0 ? count / 10 : count / 10 + 1;

        if (page <= 0) page = 1;
        else if (page > numberofpages) page = numberofpages;
        List<StudyBoardDto> list = null;
        list = studyBoardDao.selectStudyBoardPage(10 * (page - 1) + 1);
//            list = studyBoardDao.selectStudyBoardPage(count - 10 * (page - 1));
        model.addAttribute("list", list);
        model.addAttribute("currentPage", page);
        model.addAttribute("lastPage", numberofpages);
        System.out.println("page = " + page);
        System.out.println("numberofpages = " + numberofpages);
        return "studyBoardList";
    }

    @GetMapping("/study/insert")
    public String insertForm(HttpServletRequest request) {

        return "studyBoardInsertForm";
    }

    @PostMapping("/study/insert")
    public String insertStudyBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String title1 = request.getParameter("title");
        String content1 = request.getParameter("content");
        System.out.println("title1 = " + title1);
        System.out.println("content1 = " + content1);
        StudyBoardDto dto = new StudyBoardDto();
        dto.setTitle(title1);
        dto.setContent(content1);
        int result = studyBoardDao.insertStudyBoard(dto);
        System.out.println("insert result = " + result);
        return "redirect: /board/study/list?page=1";
    }

    @GetMapping("/study/update")
    public String updateStudyBoard(Model model, int bno) throws Exception {

        StudyBoardDto studyBoardDto = null;
        studyBoardDto = studyBoardDao.selectStudyBoard(bno);
        model.addAttribute("board", studyBoardDto);
        return "studyBoardUpdateForm";


    }

    @PostMapping("/study/update")
    public String updateStudyBoard2(String content, String title, int bno)  throws Exception {
        StudyBoardDto dto = null;
        dto = studyBoardDao.selectStudyBoard(bno);
        System.out.println("bno = " + bno);

        dto.setTitle(title);
        dto.setContent(content);
        System.out.println("title = " + title);
        System.out.println("content = " + content);
        studyBoardDao.updateStudyBoard(dto);
        return "redirect: /board/study?bno=" + bno;

    }

    @GetMapping("/study/delete")
    public String deleteStudyBoard(int bno)  throws Exception {
        System.out.println("bno = " + bno);
        studyBoardDao.deleteStudyBoard(bno);
        return "redirect: /board/study/list";
    }

    @GetMapping("/etc")
    public String board2() {
        return "etcBoard";
    }
}