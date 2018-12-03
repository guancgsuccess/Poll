package com.cx.dao.impl;

import com.cx.dao.IUserDao;
import com.cx.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@Transactional
@Repository
public class UserDaoImpl implements IUserDao{
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取session
     * @return
     */
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    public User getByUsername(String username) {
        User u = (User) getSession().createQuery("from User u where u.username=:username").setParameter("username",username).uniqueResult();
     //   Hibernate.initialize(u.getRoles());
        return u;
    }
}
