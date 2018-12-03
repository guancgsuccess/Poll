package com.cx.dao.impl;

import com.cx.dao.IClazzDao;
import com.cx.entity.Clazz;
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
public class ClazzDaoImpl implements IClazzDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Clazz clazz) {
        getSession().save(clazz);
    }

    @Override
    public List<Clazz> findAll() {
        return getSession().createQuery("from Clazz order by createDate desc").list();
    }

    @Override
    public Clazz getById(Integer id) {
        return (Clazz) getSession().get(Clazz.class,id);
    }

    @Override
    public int findNum(String clazzName) {
        return (int) getSession().createQuery("select distinct num from Clazz where clazzName=:clazzName").setParameter("clazzName",clazzName).uniqueResult();
    }

    @Override
    public Clazz getByClazzName(String clazzName) {
        return (Clazz) getSession().createQuery("from Clazz where clazzName=:clazzName").setParameter("clazzName",clazzName).uniqueResult();
    }
}
