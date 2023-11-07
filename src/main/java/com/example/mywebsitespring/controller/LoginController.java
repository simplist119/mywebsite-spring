package com.example.mywebsitespring.controller;

import com.example.mywebsitespring.dao.UserDao;
import com.example.mywebsitespring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserDao userDao;

    @GetMapping("/loginController")
    public String login() {
        return "loginForm";
    }

    @PostMapping("/LoginController")
    public String loginSubmit(String id, String pwd, HttpServletRequest request, HttpServletResponse response) {
        User user = null;
        user = userDao.selectUser(id);
        System.out.println("id2 : " + id);
        System.out.println("pwd2 : " + pwd);
        System.out.println(user);
        if (user == null) {
            System.out.println("1111");
            return "index";
        }
        if (user.getPwd().equals(pwd)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("id", id);
            System.out.println(session);
            System.out.println("2222");
            return "index";
        }
        System.out.println("3333");
        return "redirect: index";
    }

    @GetMapping
    public String logOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";

    }
}
