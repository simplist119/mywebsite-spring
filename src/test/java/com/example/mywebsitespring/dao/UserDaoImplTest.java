package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest {

    @Autowired
    UserDao userDao;

    @Test
    public void selectUser() {
        String id = "a1";
        UserDto userDto = null;
        userDto = userDao.selectUser(id);
        System.out.println("user : " + userDto);
        assertTrue(userDto != null);
    }

    @Test
    public void selectAll() {
        List<UserDto> list = null;
        list = userDao.selectAll();
        System.out.println("selectAll : " + list);
        assertTrue(list != null);
    }

    @Test
    public void updateUser() {
        UserDto user = new UserDto("aaaa", "1234", "kong", "abc@abc.com", new Date(), new Date());
        int result = userDao.updateUser(user);

        System.out.println("result : " + result);
        assertTrue(result >= 1);
    }

//    TODO : 나는 StudyboardDaoImpltest를 하는데 왜 여기서 오류가 뜰까?ㅡㅡ
    @Test
    public void insertUser() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(1999, 12, 12);
        int result = 0;
        UserDto user1 = new UserDto("aaaa13", "1234", "jack", "abc@abc.com", new Date(cal.getTimeInMillis()), new Date());
        result = userDao.insertUser(user1);
        System.out.println("result : " + result);
        assertTrue(result >= 1);
    }

    @Test
    public void deleteUser() {
        String id = "a1";
        int result = 0;
        result = userDao.deleteUser(id);
        System.out.println("result : " + result);
        assertTrue(result >= 1);
    }

    @Test
    public void deleteAll() {
        int result = 0;
        result = userDao.deleteAll();
        System.out.println("result : " + result);
        assertTrue(result >= 1);
    }
}