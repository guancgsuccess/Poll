package com.cx.vo;

/**
 * 第三方实体类,用来封装clazzName,ukey,questions_id,平均数
 */
public class ScoreVo {
    private String clazzName;

    private String ukey;

    private Long questions_id;

    private Double score;

    public ScoreVo() {
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    public Long getQuestions_id() {
        return questions_id;
    }

    public void setQuestions_id(Long questions_id) {
        this.questions_id = questions_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoreVo scoreVo = (ScoreVo) o;

        return ukey != null ? ukey.equals(scoreVo.ukey) : scoreVo.ukey == null;
    }

    @Override
    public int hashCode() {
        return ukey != null ? ukey.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ScoreVo{");
        sb.append("clazzName='").append(clazzName).append('\'');
        sb.append(", ukey='").append(ukey).append('\'');
        sb.append(", questions_id=").append(questions_id);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
