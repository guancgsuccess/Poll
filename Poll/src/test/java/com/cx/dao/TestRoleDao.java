package com.cx.dao;

import com.cx.entity.Role;
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
public class TestRoleDao extends AbstractTestNGSpringContextTests{

    @Autowired
    private IRoleDao roleDao;

    @Test
    public void testSave(){
        Role r1 = new Role();
        r1.setRole("项目经理");
        r1.setDescription("授课老师");
        roleDao.save(r1);

        Role r2 = new Role();
        r2.setRole("班主任");
        r2.setDescription("教学日常管理");
        roleDao.save(r2);
    }
}
