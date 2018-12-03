package com.cx.dao;

import com.cx.entity.Questions;

import java.util.List;

/**
 * 试卷
 */
public interface IQuestionsDao {

    /**
     * 保存问题
     * @param questions
     */
    void save(Questions questions);

    /**
     * 选择第几套问卷
     * @param status
     * @return
     */
    List<Questions> findAll(Integer status);

    /**
     * 根据问卷的id来查询问卷
     * @param id
     * @return
     */
    Questions getById(Integer id);

    /**
     * 统计问卷的套数..
     * @return
     */
    long getTotals();
}
