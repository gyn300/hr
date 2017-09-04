package com.jee.po;


import java.util.Date;

public class Interview {
    private int id;
    private int user_id;
    private Date interviewTime;
    private int checkStatus;
    private int interviewStatus;
    private int employStatus;

    public Interview(int id, int user_id, Date interviewTime, int checkStatus, int interviewStatus, int employStatus) {
        this.id = id;
        this.user_id = user_id;
        this.interviewTime = interviewTime;
        this.checkStatus = checkStatus;
        this.interviewStatus = interviewStatus;
        this.employStatus = employStatus;
    }



    public Interview() {
    }

    public Interview(int user_id, Date interviewTime) {
        this.user_id = user_id;
        this.interviewTime = interviewTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(Date interviewTime) {
        this.interviewTime = interviewTime;
    }



    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public int getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(int interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public int getEmployStatus() {
        return employStatus;
    }

    public void setEmployStatus(int employStatus) {
        this.employStatus = employStatus;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", interviewTime=" + interviewTime +
                ", checkStatus=" + checkStatus +
                ", interviewStatus=" + interviewStatus +
                ", employStatus=" + employStatus +
                '}';
    }
}
