//package com.example.mywebsitespring.controller;
//
//
//import com.example.mywebsitespring.dao.StudyBoardDao;
//import com.example.mywebsitespring.domain.StudyBoardDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//@Controller
//@RequestMapping("/board")
//public class BoardController {
//
//    @Autowired
//    StudyBoardDao studyBoardDao;
//
//    //보드리스트 띄워줌
//    @GetMapping("/study")
//    public String board3(int bno, Model model) {
//    }
//
//    @GetMapping("/study/list")
//    public String board1(int page, Model model) throws Exception {
//    }
//
//    @GetMapping("/study/insert")
//    public String insertForm(HttpServletRequest request) {
//    }
//
//    @PostMapping("/study/insert")
//    public String insertStudyBoard(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    }
//
//    @GetMapping("/study/update")
//    public String updateStudyBoard(Model model, int bno) throws Exception {
//    }
//
//    @PostMapping("/study/update")
//    public String updateStudyBoard2(String content, String title, int bno)  throws Exception {
//    }
//
//    @GetMapping("/study/delete")
//    public String deleteStudyBoard(int bno)  throws Exception {
//    }
//}