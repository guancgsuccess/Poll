package com.cx.service.impl;

import com.cx.entity.Questions;
import com.cx.service.*;
import com.cx.vo.ScoreVo;
import com.cx.vo.SqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
@Service
@Transactional
public class SqVoServiceImpl implements ISqVoService{
    @Autowired
    private IScoreService scoreService;

    @Autowired
    private IClazzService clazzService;

    @Autowired
    private IQuestionsService questionsService;

    @Autowired
    private ISuggestService suggestService;

    @Override
    public List<SqVo> findAll(String clazzName, int countOrder) {
        List<ScoreVo> scoreVos = scoreService.findByOrder(clazzName,countOrder);

        List<SqVo> sqVos = new ArrayList<>();

        //统计考评人数
        int num = clazzService.findNum(clazzName);

        for(ScoreVo sv:scoreVos){
            SqVo v = new SqVo();
            v.setScoreVo(sv);
            Long qid = sv.getQuestions_id();
            Questions q = questionsService.getById(Integer.parseInt(qid.toString()));
            v.setQuestions(q);
            v.setNum(num);
            v.setOnlineCounts((int)suggestService.countJoinNum(sv.getUkey()));

            sqVos.add(v);
        }
        return sqVos;
    }
}
