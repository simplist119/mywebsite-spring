package com.example.mywebsitespring.controller;

import com.example.mywebsitespring.dao.UserDao;
import com.example.mywebsitespring.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserDao userDao;

    @GetMapping("/login")
    public String login() {
        System.out.println("enter /login get");
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginSubmit(String id, String pwd, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("enter /login post");
        UserDto userDto = null;
        userDto = userDao.selectUser(id);
        String toURL = request.getParameter("toURL");
        System.out.println("toURL : " + toURL);
        // 로그인 실패 : id 자체가 존재하지 않는다면
        if (userDto == null) {
            return "redirect: /login?toURL=" + toURL;
        }
        // 로그인 성공
        if (userDto.getPwd().equals(pwd)) {
            System.out.println("로그인 성공");
//          TODO : 타고가보면 인터페이스가 나오는데 이걸 구현한코드를 보려면 어떻게?
            HttpSession session = request.getSession(true);
            session.setAttribute("id", id);
            return "redirect: " + toURL;
        }
        // 로그인 실패 : id는 존재하지만 비밀번호는 틀릴 경우
        System.out.println("로그인 실패 : id는 존재하지만 비밀번호는 틀린 경우");
        return "redirect: /login?toURL=" + toURL;
    }

    @GetMapping("/logout")
//    TODO : 원장님 한테물어보기 GetMapping
    public String logOut(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect: /";
    }
}
