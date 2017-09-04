package com.jee.po;


import java.util.Date;

public class Salary {
    private int id;
    private int user_id;
    private double totalSalary;
    private double baseSalary;
    private double performanceSalary;
    private double overtimeSalary;
    private double bonuspenaltySalary;
    private double socialSecurity;
    private Date date;

    public Salary() {
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

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getPerformanceSalary() {
        return performanceSalary;
    }

    public void setPerformanceSalary(double performanceSalary) {
        this.performanceSalary = performanceSalary;
    }

    public double getOvertimeSalary() {
        return overtimeSalary;
    }

    public void setOvertimeSalary(double overtimeSalary) {
        this.overtimeSalary = overtimeSalary;
    }

    public double getBonuspenaltySalary() {
        return bonuspenaltySalary;
    }

    public void setBonuspenaltySalary(double bonuspenaltySalary) {
        this.bonuspenaltySalary = bonuspenaltySalary;
    }

    public double getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(double socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", totalSalary=" + totalSalary +
                ", baseSalary=" + baseSalary +
                ", performanceSalary=" + performanceSalary +
                ", overtimeSalary=" + overtimeSalary +
                ", bonuspenaltySalary=" + bonuspenaltySalary +
                ", socialSecurity=" + socialSecurity +
                ", date=" + date +
                '}';
    }
}
