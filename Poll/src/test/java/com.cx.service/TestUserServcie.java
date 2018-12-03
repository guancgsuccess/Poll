package com.cx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestUserServcie extends AbstractTestNGSpringContextTests{
    @Autowired
    private IUserService userService;

    /**
     * 测试登录
     */
    @Test
    public void testLogin(){
        System.out.println(userService.login("王静静"));
    }
}
