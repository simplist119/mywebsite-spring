package com.example.mywebsitespring.controller;

import com.example.mywebsitespring.dao.UserDao;
import com.example.mywebsitespring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

import static org.junit.Assert.assertTrue;

@Controller
public class SignUpController {

    @Autowired
    UserDao userDao;

    @GetMapping("/signup")
    public String signUp() {
        System.out.println("get signup");
        return "signUpForm";
    }

    @PostMapping("/signup")
    public String signUp2(User user, BindingResult result2) {

//        Calendar cal = Calendar.getInstance();
//        cal.clear();
//        cal.set(1999, 12, 12);
//        User user1 = new User("aaaa3", "1234", "jack", "abc@abc.com", new Date(cal.getTimeInMillis()), new Date());
//        TODO : 날짜 처리하기  마이바티스자동커밋코드

        user.setBirth(new Date());
        user.setReg_date(new Date());
        int result = 0;
        result = userDao.insertUser(user);
        System.out.println("insert result : " + result);
        System.out.println("post signup");
        System.out.println("user : " + user);
        System.out.println("BindingResult : " + result2);
        return "redirect: /";
    }
}
