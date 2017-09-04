package com.jee.po;


import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private int user_id;
    private String department;
    private String position;
    private int age;
    private Date inductionTime;
    private Date leaveTime;
    public Employee() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getInductionTime() {
        return inductionTime;
    }

    public void setInductionTime(Date inductionTime) {
        this.inductionTime = inductionTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user_id=" + user_id +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}
