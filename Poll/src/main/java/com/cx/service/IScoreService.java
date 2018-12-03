package com.cx.service;

import com.cx.entity.Score;
import com.cx.vo.ExportObjVo;
import com.cx.vo.ScoreVo;

import java.io.OutputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/7/26 0026.
 */
public interface IScoreService {
    void save(Score score);


    /**
     * 查询某个班级第几次统计的结果
     * @param clazzName
     * @return
     */
    List<ScoreVo> findByOrder(String clazzName,int index);

    /**
     * 一键导出分数
     * @param vo
     * @param countOrder
     * @param outputStream
     */
    void export(ExportObjVo vo, int countOrder,OutputStream outputStream);
}
