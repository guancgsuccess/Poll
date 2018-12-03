package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 得分表.
 */
@Table(name = "sys_score")
@Entity
public class Score implements Serializable{
    private Integer id;

    private Questions questions;

    private double score;

    private Date createDate;

    private String clazzName;

    private String teacher;

    private String ukey;

    public Score() {
    }

    public Score(Integer id, Questions questions, double score, Date createDate, String clazzName, String ukey) {
        this.id = id;
        this.questions = questions;
        this.score = score;
        this.createDate = createDate;
        this.clazzName = clazzName;
        this.ukey = ukey;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    @Column
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Column
    @Temporal(TemporalType.DATE)
    public Date getCreateDate() {
        return createDate;
    }

    @Column
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column
    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Column
    public String getUkey() {
        return ukey;
    }

    public void setUkey(String ukey) {
        this.ukey = ukey;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Score{");
        sb.append("id=").append(id);
        sb.append(", questions=").append(questions);
        sb.append(", score=").append(score);
        sb.append(", createDate=").append(createDate);
        sb.append(", clazzName='").append(clazzName).append('\'');
        sb.append(", ukey='").append(ukey).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
