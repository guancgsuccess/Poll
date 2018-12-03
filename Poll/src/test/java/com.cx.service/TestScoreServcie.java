package com.cx.service;

import com.cx.vo.ScoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestScoreServcie extends AbstractTestNGSpringContextTests{
    @Autowired
    private IScoreService scoreService;

    @Test
    public void testFindByOrder(){
        List<ScoreVo> vos = scoreService.findByOrder("J01180709",0);
        for(ScoreVo v:vos){
            System.out.println(v);
        }
    }
}
