package com.cx.dao;

import com.cx.entity.Clazz;

import java.util.List;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
public interface IClazzDao {

    /**
     * 保存班级信息
     * @param clazz
     */
    void save(Clazz clazz);

    /**
     * 查询班级根据创建班级时间降序排序.
     * @return
     */
    List<Clazz> findAll();

    /**
     * 根据班级id查询班级信息
     * @param id
     * @return
     */
    Clazz getById(Integer id);

    /**
     * 找出该班级的人数
     * @param clazzName
     * @return
     */
    int findNum(String clazzName);

    /**
     * 根据班级名称来查找班级
     * 注意:一个班级只有一个教师和班主任
     * @param clazzName
     * @return
     */
    Clazz getByClazzName(String clazzName);

}
