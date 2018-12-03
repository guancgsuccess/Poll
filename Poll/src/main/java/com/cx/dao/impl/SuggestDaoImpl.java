package com.cx.dao.impl;

import com.cx.dao.ISuggestDao;
import com.cx.entity.Suggest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
@Repository
@Transactional
public class SuggestDaoImpl implements ISuggestDao{

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Suggest suggest) {
            getSession().save(suggest);
    }

    @Override
    public long countPoll(String clazzName) {
        return (long) getSession().createQuery("select count(distinct uniquekey) from Suggest where clazzName=:clazzName").setParameter("clazzName",clazzName).uniqueResult();
    }

    @Override
    public List<String> getUniqueKeys(String clazzName) {
        return getSession().createQuery("select uniquekey from Suggest where clazzName=:clazzName order by createDate").setParameter("clazzName",clazzName).list();
    }

    @Override
    public long countJoinNum(String ukey) {
        return (long) getSession().createQuery("select count(*) from Suggest where uniquekey=:ukey").setParameter("ukey",ukey).uniqueResult();
    }

    @Override
    public List<String> getContentsByUkey(String ukey) {
        return getSession().createQuery("select content from Suggest where uniquekey=:ukey").setParameter("ukey",ukey).list();
    }
}
