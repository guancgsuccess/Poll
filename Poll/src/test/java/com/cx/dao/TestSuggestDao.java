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
public class TestSuggestDao extends AbstractTestNGSpringContextTests{

    @Autowired
    private ISuggestDao suggestDao;

    @Test
    public void testGetUniquekeyByClazzName(){
        System.out.println(suggestDao.getUniqueKeys("J01180709"));
    }

    @Test
    public void testCountJoinNum(){
        System.out.println(suggestDao.countJoinNum("8b64fc33-afdb-4068-9462-99ef75935c23"));
    }

    @Test
    public void testGetContentByUkey(){
        List<String> contents = suggestDao.getContentsByUkey("1c335dee-adbe-4105-bcc0-783624c671e3");
        for(String c:contents){
            System.out.println(c);
        }
    }
}
