package com.cx.service;

import com.cx.vo.SqVo;

import java.util.List;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
public interface ISqVoService {

    List<SqVo> findAll(String clazzName, int countOrder);

}
