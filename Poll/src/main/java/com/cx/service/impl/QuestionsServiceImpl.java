package com.cx.service.impl;

import com.cx.dao.IQuestionsDao;
import com.cx.entity.Questions;
import com.cx.service.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
@Service
@Transactional
public class QuestionsServiceImpl implements IQuestionsService{

    @Autowired
    private IQuestionsDao questionsDao;

    @Override
    public List<Questions> findAll(Integer status) {
        return questionsDao.findAll(status);
    }

    @Override
    public Questions getById(Integer id) {
        return questionsDao.getById(id);
    }

    @Override
    public long getTotals() {
        return questionsDao.getTotals();
    }
}
