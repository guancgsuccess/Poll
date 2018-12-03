package com.cx.vo;

import com.cx.entity.Questions;

/**
 * 第三方实体类,用来封装Questions以及ScoreVo以及班级人数,参与人数
 */
public class SqVo {
    private Questions questions;

    private ScoreVo scoreVo;

    private int num;

    private int onlineCounts;

    public SqVo() {
    }

    public int getNum() {
        return num;
    }

    public int getOnlineCounts() {
        return onlineCounts;
    }

    public void setOnlineCounts(int onlineCounts) {
        this.onlineCounts = onlineCounts;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public ScoreVo getScoreVo() {
        return scoreVo;
    }

    public void setScoreVo(ScoreVo scoreVo) {
        this.scoreVo = scoreVo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SqVo{");
        sb.append("questions=").append(questions);
        sb.append(", scoreVo=").append(scoreVo);
        sb.append('}');
        return sb.toString();
    }
}
