package com.jee.po;


import java.util.Date;

public class Bonuspenalty {
    private int id;
    private String name;
    private int user_id;
    private String explains;
    private Date time;
    private Double money;

    public Bonuspenalty() {
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

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

}
