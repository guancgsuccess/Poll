package com.cx.dao;

import com.cx.entity.Role;
import com.cx.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
@WebAppConfiguration
public class TestUserDao extends AbstractTestNGSpringContextTests{

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    /**
     * 保存单个用户对象
     */
    @Test
    public void testSave(){
        User u1 = new User();
        u1.setUsername("王静静");
        u1.setPassword("admin");
        u1.setPower(1);

        User u3 = new User();
        u3.setUsername("任津辉");
        u3.setPassword("admin");
        u3.setPower(1);

        User u4 = new User();
        u4.setUsername("强红娟");
        u4.setPassword("admin");
        u4.setPower(1);

        User u5 = new User();
        u5.setUsername("詹亮");
        u5.setPassword("admin");
        u5.setPower(1);

        User u6 = new User();
        u6.setUsername("陈文娟");
        u6.setPassword("admin");
        u6.setPower(1);

        User u7 = new User();
        u7.setUsername("李详辉");
        u7.setPassword("admin");
        u7.setPower(1);


        User u2 = new User();
        u2.setUsername("管成功");
        u2.setPassword("success");
        u2.setPower(0);
      //  userDao.save(u1);
      //  userDao.save(u2);
      //  userDao.save(u3);

        userDao.save(u4);
        userDao.save(u5);
        userDao.save(u6);
        userDao.save(u7);
    }

    /**
     * 保存用户角色表
     */
    @Test
    public void testSaveUserAndRoles(){
        User u = userDao.getByUsername("王静静");
        System.out.println(u.getRoles());


    }
}
