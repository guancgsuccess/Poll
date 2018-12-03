package com.cx.dao;

import com.cx.entity.Questions;
import com.cx.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestScoreDao extends AbstractTestNGSpringContextTests{

    @Autowired
    private IScoreDao scoreDao;

    @Test
    public void testFindByClazzName(){
        List<ScoreVo> vos = scoreDao.findByClazzName("J01180709");
        for(ScoreVo vo:vos){
            System.out.println(vo);
        }
    }
}
