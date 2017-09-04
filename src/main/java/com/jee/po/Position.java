package com.jee.po;


public class Position {
    private int id;
    private int department_id;
    private String positionName;

    public Position(int id, int department_id, String positionName) {
        this.id = id;
        this.department_id = department_id;
        this.positionName = positionName;
    }

    public Position() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", department_id=" + department_id +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
