package com.cx.service;

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
public class TestSuggestServcie extends AbstractTestNGSpringContextTests{
    @Autowired
    private ISuggestService suggestService;

    /**
     * 测试登录
     */
    @Test
    public void testDistinctUniqueKey(){
      List<String> keys = suggestService.distinctUniqueKey("J01180709");
      for(String k:keys){
          System.out.println(k);
      }
    }
}
