package com.cx.service;

import com.cx.entity.Clazz;

import java.util.List;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
public interface IClazzService {
    List<Clazz> findAll();

    Clazz getById(Integer id);

    /**
     * 找出该班级的人数
     * @param clazzName
     * @return
     */
    int findNum(String clazzName);

    /**
     * 根据班级名称来查找名称
     * @param clazzName
     * @return
     */
    Clazz getByClazzName(String clazzName);
}
