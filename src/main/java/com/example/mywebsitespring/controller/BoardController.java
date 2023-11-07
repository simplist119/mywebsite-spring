package com.example.mywebsitespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/studyboard")
    public String board1() {
        return "studyBoard";
    }

    @GetMapping("/etcboard")
    public String board2() {
        return "etcBoard";
    }

}
