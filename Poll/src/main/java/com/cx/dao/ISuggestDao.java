package com.cx.dao;

import com.cx.entity.Suggest;

import java.util.List;

/**
 * 建议
 */
public interface ISuggestDao {

    void save(Suggest suggest);

    /**
     * 统计每个班级测评次数
     * @param clazzName
     * @return
     */
    long countPoll(String clazzName);

    /**
     * 根据名称进行查找
     * @param clazzName
     * @return
     */
    List<String> getUniqueKeys(String clazzName);

    /**
     * 统计参与测评人数
     * @param ukey
     * @return
     */
    long countJoinNum(String ukey);

    List<String> getContentsByUkey(String ukey);
}
