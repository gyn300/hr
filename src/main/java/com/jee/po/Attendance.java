package com.jee.po;


import java.util.Date;

public class Attendance {
    private int id;
    private int user_id;
    private Date workTime;
    private Date offWorkTime;
    private int lateStatus;
    private int leaveEarlyStatus;
    private Date date;

    public Attendance() {
    }

    public Attendance(int user_id, Date date) {
        this.user_id = user_id;
        this.date = date;
    }

    public Attendance(int id, int user_id, Date workTime, Date offWorkTime, int lateStatus, int leaveEarlyStatus, Date date) {
        this.id = id;
        this.user_id = user_id;
        this.workTime = workTime;
        this.offWorkTime = offWorkTime;
        this.lateStatus = lateStatus;
        this.leaveEarlyStatus = leaveEarlyStatus;
        this.date = date;
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

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Date getOffWorkTime() {
        return offWorkTime;
    }

    public void setOffWorkTime(Date offWorkTime) {
        this.offWorkTime = offWorkTime;
    }

    public int getLateStatus() {
        return lateStatus;
    }

    public void setLateStatus(int lateStatus) {
        this.lateStatus = lateStatus;
    }

    public int getLeaveEarlyStatus() {
        return leaveEarlyStatus;
    }

    public void setLeaveEarlyStatus(int leaveEarlyStatus) {
        this.leaveEarlyStatus = leaveEarlyStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", workTime=" + workTime +
                ", offWorkTime=" + offWorkTime +
                ", lateStatus=" + lateStatus +
                ", leaveEarlyStatus=" + leaveEarlyStatus +
                '}';
    }
}
