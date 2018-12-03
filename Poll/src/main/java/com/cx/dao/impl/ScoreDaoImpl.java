package com.cx.dao.impl;

import com.cx.dao.IScoreDao;
import com.cx.entity.Score;
import com.cx.vo.ScoreVo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
@Repository
@Transactional
public class ScoreDaoImpl implements IScoreDao{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Score score) {
        getSession().save(score);
    }

    @Override
    public List<ScoreVo> findByClazzName(String clazzName) {
        String sql="select clazzName,ukey,questions_id,avg(score) from sys_score where clazzName=:clazzName group by clazzName,ukey,questions_id order by 2,3";
        List<Object[]> results = getSession().createSQLQuery(sql).setParameter("clazzName",clazzName).list();

        List<ScoreVo> scoreVos = new ArrayList<>();

        for(Object[] obj:results){
            String cname= (String) obj[0];
            String ukey = (String) obj[1];
            Long questions_id = Long.valueOf(String.valueOf(obj[2]));
            Double score = Double.valueOf(String.valueOf(obj[3]));

            ScoreVo vo = new ScoreVo();
            vo.setClazzName(cname);
            vo.setUkey(ukey);
            vo.setQuestions_id(questions_id);
            vo.setScore(score);

            scoreVos.add(vo);
        }
        return scoreVos;
    }
}
