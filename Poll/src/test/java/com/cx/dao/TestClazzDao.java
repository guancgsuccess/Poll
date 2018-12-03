package com.cx.dao;

import com.cx.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestClazzDao extends AbstractTestNGSpringContextTests{

    @Autowired
    private IClazzDao clazzDao;

    @Test
    public void testSave(){
        Clazz c1 = new Clazz();
        c1.setClazzName("J01180709");
        c1.setTeacher("强老师");
        c1.setCreateDate(new Date());
        c1.setMaster("任津辉");
        c1.setStatus(0);
        c1.setNum(45);
        c1.setJober("李丰");

        Clazz c2 = new Clazz();
        c2.setClazzName("P01180709");
        c2.setTeacher("詹老师");
        c2.setMaster("任津辉");
        c2.setCreateDate(new Date());
        c2.setStatus(1);
        c2.setNum(45);
        c2.setJober("李丰");

        clazzDao.save(c1);
        clazzDao.save(c2);
    }

    @Test
    public void findAll(){
        List<Clazz> clazzs = clazzDao.findAll();
        for(Clazz c:clazzs){
            System.out.println(c);
        }
    }

    @Test
    public void findNum(){
        System.out.println(clazzDao.findNum("J01180709"));
    }

    @Test
    public void findByClazzName(){
        System.out.println(clazzDao.getByClazzName("J01180709"));
    }
}
