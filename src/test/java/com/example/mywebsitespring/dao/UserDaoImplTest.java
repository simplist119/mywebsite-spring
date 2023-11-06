package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.User;
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
        String id = "aaaa2";
        User user = null;
        user = userDao.selectUser(id);
        System.out.println("user : " + user);
        assertTrue(user != null);
    }

    @Test
    public void selectAll() {
        List<User> list = null;
        list = userDao.selectAll();
        System.out.println("selectAll : " + list);
        assertTrue(list != null);
    }

    @Test
    public void updateUser() {
        User user = new User("aaaa", "1234", "kong", "abc@abc.com", new Date(), new Date());
        int result = userDao.updateUser(user);

        System.out.println("result : " + result);
        assertTrue(result >= 1);
    }

    @Test
    public void insertUser() {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(1999, 12, 12);
        int result = 0;
        User user1 = new User("aaaa3", "1234", "jack", "abc@abc.com", new Date(cal.getTimeInMillis()), new Date());
        result = userDao.insertUser(user1);
        System.out.println("result : " + result);
        assertTrue(result >= 1);
    }

    @Test
    public void deleteUser() {
        String id = "aaaa";
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