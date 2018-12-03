package com.cx.dao;

import com.cx.entity.Score;
import com.cx.vo.ExportObjVo;
import com.cx.vo.ScoreVo;

import java.util.List;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
public interface IScoreDao {
    void save(Score score);

    List<ScoreVo> findByClazzName(String clazzName);
}
