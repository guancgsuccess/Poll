package com.cx.init;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018/7/24 0024.
*/
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class InitTables extends AbstractTestNGSpringContextTests{

    @Autowired
    public SessionFactory sessionFactory;

    /**
     * 测试数据源
     */
    @Test
    public void testSessionFactory(){
        System.out.println(sessionFactory);
    }

    /**
     * 初始化表结构
     */
    @Test
    public void testInitTables(){
        Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
        SchemaExport se = new SchemaExport(cfg);
        se.create(true,true);
    }
}
