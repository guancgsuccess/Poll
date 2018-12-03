package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 建议表
 */
@Entity
@Table(name="sys_suggest")
public class Suggest implements Serializable{

    private Integer id;

    private String content;

    private Date createDate;

    private String teacher;

    private String clazzName;

    private String uniquekey;

    public Suggest() {
    }

    public Suggest(String content, Date createDate, String teacher, String clazzName, String uniquekey) {
        this.content = content;
        this.createDate = createDate;
        this.teacher = teacher;
        this.clazzName = clazzName;
        this.uniquekey = uniquekey;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column
    @Temporal(TemporalType.DATE)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Column
    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Column
    public String getUniquekey() {
        return uniquekey;
    }

    public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Suggest{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", teacher='").append(teacher).append('\'');
        sb.append(", clazzName='").append(clazzName).append('\'');
        sb.append(", uniquekey='").append(uniquekey).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
