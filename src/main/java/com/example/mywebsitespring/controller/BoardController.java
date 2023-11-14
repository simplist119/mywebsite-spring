package com.example.mywebsitespring.controller;

import com.example.mywebsitespring.dao.StudyBoardDao;
import com.example.mywebsitespring.domain.StudyBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    StudyBoardDao studyBoardDao;

    @GetMapping("/studyboard")
    public String board3(int bno, Model model) {

        StudyBoardDto studyBoardDto = null;
        studyBoardDto = studyBoardDao.selectStudyBoard(bno);
        if (studyBoardDto != null) {
            studyBoardDto.setView_cnt(studyBoardDto.getView_cnt() + 1);
            studyBoardDao.updateStudyBoard(studyBoardDto);
        }
        model.addAttribute("board", studyBoardDto);
        return "studyBoard";
    }

    @GetMapping("/studyboardlist")
    public String board1(int page, Model model) {
        int count = studyBoardDao.countStudyBoard();
        System.out.println("count = " + count);
        int numberofpages = count % 10 == 0 ? count / 10 : count / 10 + 1;

        // TODO: 2023-11-14 아래 두 경우에 아무 반응 없게하고 싶으면 return 어떻게?
        // TODO: 2023-11-14 redirect 재귀 안됨?
        //첫페이지인데 이전페이지를 눌렀을 때
//        if (page <= 0) {
//            return "/";
////            return "redirect: /studyboardlist?page=1";
//        }
//        //마지막 페이지인데 다음페이지를 눌렀을 때
//        else if ((page > numberofpages) && page>0) {
////            return "redirect: /studyboardlist?page=" + numberofpages;
//            return "/";
//        }
//        //정상적인 페이지 요청 (존재하는 페이지)
//        else {
        if(page<=0) page=1;
        else if(page > numberofpages) page = numberofpages;
            List<StudyBoardDto> list = null;
            list = studyBoardDao.selectStudyBoardPage(count - 10 * (page - 1));
            model.addAttribute("list", list);
            model.addAttribute("currentPage", page);
            model.addAttribute("lastPage", numberofpages);
            System.out.println("page = " + page);
            System.out.println("numberofpages = " + numberofpages);
            return "studyBoardList";
    }

    @GetMapping("/studyboard/insertForm")
    public String insertForm() {
        return "insertStudyBoardForm";
    }

    @PostMapping("/studyboard/insert")
    public String insertStudyBoard(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");
        System.out.println("id : " + id);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        System.out.println("title = " + title);
        System.out.println("content = " + content);
        StudyBoardDto dto = new StudyBoardDto();
        dto.setTitle(title);
        dto.setContent(content);
        dto.setWriter(id);
//        model.addAttribute("dto", dto);
        studyBoardDao.insertStudyBoard(dto);
        return "redirect: /studyboardlist";

    }

    @GetMapping("/studyboard/update")
    public String updateStudyBoard(Model model, int bno) {

        StudyBoardDto studyBoardDto = null;
        studyBoardDto = studyBoardDao.selectStudyBoard(bno);
        model.addAttribute("board", studyBoardDto);
        return "updateStudyBoard";


    }

    @PostMapping("/studyboard/update")
    public String updateStudyBoard2(String content, String title, int bno) {
        StudyBoardDto dto = null;
        dto = studyBoardDao.selectStudyBoard(bno);
        System.out.println("bno = " + bno);

        dto.setTitle(title);
        dto.setContent(content);
        System.out.println("title = " + title);
        System.out.println("content = " + content);
        studyBoardDao.updateStudyBoard(dto);
        return "redirect: /studyboard?bno=" + bno;

    }

    @GetMapping("/studyboard/delete")
    public String deleteStudyBoard(int bno) {
        System.out.println("bno = " + bno);
        studyBoardDao.deleteStudyBoard(bno);
        return "redirect: /studyboardlist";
    }

    @GetMapping("/etcboard")
    public String board2() {
        return "etcBoard";
    }
}