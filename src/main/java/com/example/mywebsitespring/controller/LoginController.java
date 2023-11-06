package com.example.mywebsitespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/loginController")
    public String login(){
        return "loginForm";
    }

    @PostMapping("LoginController")
    public String loginCheck(){
        return "index";
    }
}
