package com.cx.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 导出excel封装班级名称,实训师,得分,班主任,得分.班级人数,实际参与测评人数
 */
public class ExportObjVo implements Serializable{
    //班级名称
    private String clazzName;

    //实训师
    private String teacher;

    //实训师得分
    private double total1;

    //班主任
    private String master;

    //班主任得分
    private double total2;

    //班级人数
    private int mustCounts;

    //实际参与人数
    private int onlineCounts;

    //评价
    private List<String> contents;

    //问题和得分
    private List<SqVo> sqVos;

    public ExportObjVo() {
    }

    public List<SqVo> getSqVos() {
        return sqVos;
    }

    public void setSqVos(List<SqVo> sqVos) {
        this.sqVos = sqVos;
    }

    public List<String> getContents() {
        return contents;
    }

    public void setContents(List<String> contents) {
        this.contents = contents;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public double getTotal1() {
        return total1;
    }

    public void setTotal1(double total1) {
        this.total1 = total1;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public double getTotal2() {
        return total2;
    }

    public void setTotal2(double total2) {
        this.total2 = total2;
    }

    public int getMustCounts() {
        return mustCounts;
    }

    public void setMustCounts(int mustCounts) {
        this.mustCounts = mustCounts;
    }

    public int getOnlineCounts() {
        return onlineCounts;
    }

    public void setOnlineCounts(int onlineCounts) {
        this.onlineCounts = onlineCounts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ExportObjVo{");
        sb.append("clazzName='").append(clazzName).append('\'');
        sb.append(", teacher='").append(teacher).append('\'');
        sb.append(", total1=").append(total1);
        sb.append(", master='").append(master).append('\'');
        sb.append(", total2=").append(total2);
        sb.append(", mustCounts=").append(mustCounts);
        sb.append(", onlineCounts=").append(onlineCounts);
        sb.append('}');
        return sb.toString();
    }
}
