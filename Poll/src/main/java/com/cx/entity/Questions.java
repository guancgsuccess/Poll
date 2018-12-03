package com.cx.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 试卷
 */
@Table(name="sys_questions")
@Entity
public class Questions implements Serializable{
    private Integer id;

    private String content;

    private String selection1;

    private String selection2;

    private String selection3;

    private String selection4;

    //项目经理0，班主任1，就业老师2
    private int type;

    //开始调查，结束调查
    private int status;

    public Questions() {
    }

    public Questions(String content, String selection1, String selection2, String selection3, String selection4, int type, int status) {
        this.content = content;
        this.selection1 = selection1;
        this.selection2 = selection2;
        this.selection3 = selection3;
        this.selection4 = selection4;
        this.type = type;
        this.status = status;
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
    public String getSelection1() {
        return selection1;
    }

    public void setSelection1(String selection1) {
        this.selection1 = selection1;
    }

    @Column
    public String getSelection2() {
        return selection2;
    }

    public void setSelection2(String selection2) {
        this.selection2 = selection2;
    }

    @Column
    public String getSelection3() {
        return selection3;
    }

    public void setSelection3(String selection3) {
        this.selection3 = selection3;
    }

    @Column
    public String getSelection4() {
        return selection4;
    }

    public void setSelection4(String selection4) {
        this.selection4 = selection4;
    }

    @Column
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Questions{");
        sb.append("id=").append(id);
        sb.append(", content='").append(content).append('\'');
        sb.append(", selection1='").append(selection1).append('\'');
        sb.append(", selection2='").append(selection2).append('\'');
        sb.append(", selection3='").append(selection3).append('\'');
        sb.append(", selection4='").append(selection4).append('\'');
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
