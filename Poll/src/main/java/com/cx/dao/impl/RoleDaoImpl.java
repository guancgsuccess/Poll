package com.cx.dao.impl;

import com.cx.dao.IRoleDao;
import com.cx.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@Repository
@Transactional
public class RoleDaoImpl implements IRoleDao{
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Role role) {
        getSession().save(role);
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) getSession().createQuery("from Role").list();
    }
}
