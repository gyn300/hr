package com.jee.po;


import java.util.Date;

public class Educate {
    private int id;
    private Date educateTime;
    private String educateDepartment;
    private String educateName;
    private int status;

    public Educate() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEducateTime() {
        return educateTime;
    }

    public void setEducateTime(Date educateTime) {
        this.educateTime = educateTime;
    }

    public String getEducateDepartment() {
        return educateDepartment;
    }

    public void setEducateDepartment(String educateDepartment) {
        this.educateDepartment = educateDepartment;
    }

    public String getEducateName() {
        return educateName;
    }

    public void setEducateName(String educateName) {
        this.educateName = educateName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Educate{" +
                "id=" + id +
                ", educateTime=" + educateTime +
                ", educateDepartment='" + educateDepartment + '\'' +
                ", educateName='" + educateName + '\'' +
                '}';
    }
}
