package com.cx.dao.impl;

import com.cx.dao.IQuestionsDao;
import com.cx.entity.Questions;
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
public class QuestionsDaoImpl implements IQuestionsDao{
    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Questions questions) {
        getSession().save(questions);
    }

    @Override
    public List<Questions> findAll(Integer status) {
        if(null!=status){
            return getSession().createQuery("from Questions where status=:status order by id").setParameter("status",status).list();
        }
        return getSession().createQuery("from Questions").list();
    }

    @Override
    public Questions getById(Integer id) {
        return (Questions) getSession().createQuery("from Questions where id=:id").setParameter("id",id).uniqueResult();
    }

    @Override
    public long getTotals() {
        return (long) getSession().createQuery("select count(distinct status) from Questions").uniqueResult();
    }
}
