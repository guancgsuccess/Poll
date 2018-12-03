package com.cx.service;

import com.cx.entity.Suggest;

import java.util.List;

/**
 * 建议
 */
public interface ISuggestService {

    void save(Suggest suggest);

    /**
     * 统计每个班级测评次数
     * @param clazzName
     * @return
     */
    long countPoll(String clazzName);

    /**
     * 去重uniquey
     */
    List<String> distinctUniqueKey(String clazzName);

    /**
     * 统计参与测评人数
     * @param ukey
     * @return
     */
    long countJoinNum(String ukey);

    /**
     * 根据ukey来查找评论
     * @param ukey
     * @return
     */
    List<String> getContentsByUkey(String ukey);
}
