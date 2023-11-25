package com.example.mywebsitespring.dao;

import com.example.mywebsitespring.domain.CommentDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CommentDaoImplTest {

    @Autowired
    CommentDao commentDao;

    @Test
    public void count()  throws Exception {
        int result = commentDao.count(1);
        System.out.println("result = " + result);
        assertTrue(result != 0);
    }

    @Test
    public void select()  throws Exception {
        CommentDto dto = null;
        dto = commentDao.select(1);
        System.out.println("dto = " + dto);
        assertTrue(dto != null);
    }

    @Test
    public void selectAll()  throws Exception {
        List<CommentDto> list = null;
        list = commentDao.selectAll(1);
        System.out.println("list = " + list);
        assertTrue(list != null);
    }

    @Test
    public void delete()  throws Exception {
        Map map = new HashMap();
        map.put("cno", 1);
        map.put("writer", "default writer");
        int result = commentDao.delete(map);
        System.out.println("result = " + result);
        assertTrue(result != 0);
    }

    // TODO: 2023-11-15 이건 여러개 삭제되는데 resulttype int로 설정 안 해줘도 되는지?
    @Test
    public void deleteAll() throws Exception  {
        int result = commentDao.deleteAll(1);
        System.out.println("result = " + result);
        assertTrue(result != 0);
    }

    @Test
    public void update() throws Exception  {
        CommentDto dto = null;
        dto = commentDao.select(2);
        dto.setContent("qqq");
        int result = commentDao.update(dto);
        System.out.println("result = " + result);
        assertTrue(result == 1);

    }

    @Test
    public void insert() throws Exception  {
        CommentDto dto = new CommentDto();
        for (int i = 1; i < 30; i++) {
            dto.setBno(i / 2);
            dto.setPcno(i);
            dto.setContent("내용" + i);
            dto.setWriter("작성자" + i);
            int result = commentDao.insert(dto);
            System.out.println("result = " + result);
            assertTrue(true);
        }
    }
}