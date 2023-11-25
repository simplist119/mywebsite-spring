package com.example.mywebsitespring.controller;

import com.example.mywebsitespring.dao.UserDao;
import com.example.mywebsitespring.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

@Controller
public class SignUpController {

    @Autowired
    UserDao userDao;

    @GetMapping("/signup")
    public String signUp()  throws Exception  {
        return "signUpForm";
    }

    @PostMapping("/signup")
    public String signUp2(UserDto userDto, BindingResult result2) throws Exception  {

//        Calendar cal = Calendar.getInstance();
//        cal.clear();
//        cal.set(1999, 12, 12);
//        UserDto userDto1 = new UserDto("aaaa3", "1234", "jack", "abc@abc.com", new Date(cal.getTimeInMillis()), new Date());
//        TODO : 날짜 처리하기  마이바티스자동커밋코드
        System.out.println("userDto = " + userDto);
        userDto.setBirth(new Date());
//        userDto.setReg_date(new Date());
        userDto.setReg_date(new Date());
        System.out.println("userDto = " + userDto);
        int result = 0;
        result = userDao.insertUser(userDto);
        return "redirect: /";
    }
}
