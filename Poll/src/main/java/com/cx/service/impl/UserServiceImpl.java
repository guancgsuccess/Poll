package com.cx.service.impl;

import com.cx.dao.IUserDao;
import com.cx.entity.User;
import com.cx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public User login(String username) {
        return userDao.getByUsername(username);
    }
}
