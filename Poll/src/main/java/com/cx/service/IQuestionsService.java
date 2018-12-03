package com.cx.service;

import com.cx.entity.Questions;

import java.util.List;

/**
 * 试卷
 */
public interface IQuestionsService {
    /**
     * 选择第几套问卷
     * @param status
     * @return
     */
    List<Questions> findAll(Integer status);

    /**
     * 根据问题的id来查询问题
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
