package com.cx.service.impl;

import com.cx.dao.IClazzDao;
import com.cx.entity.Clazz;
import com.cx.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Administrator on 2018/7/25 0025.
 */
@Service
@Transactional
public class ClazzServiceImpl implements IClazzService{
    @Autowired
    private IClazzDao clazzDao;

    @Override
    public List<Clazz> findAll() {
        return clazzDao.findAll();
    }

    @Override
    public Clazz getById(Integer id) {
        return clazzDao.getById(id);
    }

    @Override
    public int findNum(String clazzName) {
        return clazzDao.findNum(clazzName);
    }

    @Override
    public Clazz getByClazzName(String clazzName) {
        return clazzDao.getByClazzName(clazzName);
    }
}
