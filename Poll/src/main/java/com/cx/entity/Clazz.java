package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/24 0024.
 */
@Table(name="sys_clazz")
@Entity
public class Clazz implements Serializable{
    private Integer id;

    private String clazzName;

    private String teacher;

    private String master;//班主任

    private Date createDate;

    private int status;//0代表java班级，1代表python班级

    private int num;//学生人数

    private String jober;//就业老师

    public Clazz() {
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
    public String getJober() {
        return jober;
    }

    public void setJober(String jober) {
        this.jober = jober;
    }

    @Column
    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    @Column
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Column
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clazz{");
        sb.append("id=").append(id);
        sb.append(", clazzName='").append(clazzName).append('\'');
        sb.append(", teacher='").append(teacher).append('\'');
        sb.append(", master='").append(master).append('\'');
        sb.append(", createDate=").append(createDate);
        sb.append(", status=").append(status);
        sb.append(", num=").append(num);
        sb.append('}');
        return sb.toString();
    }
}
