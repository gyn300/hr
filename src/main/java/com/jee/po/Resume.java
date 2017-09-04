package com.jee.po;


import java.util.Date;

public class Resume {
    private int id;
    private int user_id;
    private String name;
    private int age;
    private String sex;
    private String department;
    private String position;
    private String specialty;
    private int experience;
    private String education;
    private String graduateInstitutions;
    private int tel;
    private String email;
    private String detailExperience;
    private int checkStatus;
    private int interviewStatus;
    private Date time;

    public Resume() {
    }

    public Resume(int user_id, String name, int age, String sex, String specialty, String education, String graduateInstitutions, int tel, String email, int checkStatus, int interviewStatus, Date time) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.specialty = specialty;
        this.education = education;
        this.graduateInstitutions = graduateInstitutions;
        this.tel = tel;
        this.email = email;
        this.checkStatus = checkStatus;
        interviewStatus = interviewStatus;
        this.time = time;
    }

    public Resume(String name, int age, String sex, String department, String position, String specialty, int experience, String education, String graduateInstitutions, int tel, String email, String detailExperience, int checkStatus, int interviewStatus, Date time) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.position = position;
        this.specialty = specialty;
        this.experience = experience;
        this.education = education;
        this.graduateInstitutions = graduateInstitutions;
        this.tel = tel;
        this.email = email;
        this.detailExperience = detailExperience;
        this.checkStatus = checkStatus;
        interviewStatus = interviewStatus;
        this.time = time;
    }

    public Resume(int user_id, String name, int age, String sex, String department, String position, String specialty, int experience, String education, String graduateInstitutions, int tel, String email, String detailExperience, Date time) {
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.position = position;
        this.specialty = specialty;
        this.experience = experience;
        this.education = education;
        this.graduateInstitutions = graduateInstitutions;
        this.tel = tel;
        this.email = email;
        this.detailExperience = detailExperience;
        this.time = time;
    }

    public Resume(int id, int user_id, String name, int age, String sex, String department, String position, String specialty, int experience, String education, String graduateInstitutions, int tel, String email, String detailExperience, int checkStatus, int interviewStatus, Date time) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.position = position;
        this.specialty = specialty;
        this.experience = experience;
        this.education = education;
        this.graduateInstitutions = graduateInstitutions;
        this.tel = tel;
        this.email = email;
        this.detailExperience = detailExperience;
        this.checkStatus = checkStatus;
        interviewStatus = interviewStatus;
        this.time = time;
    }

    public Resume(String name, int age, String sex, String department, String position, String specialty, int experience, String education, String graduateInstitutions, int tel, String email, String detailExperience) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.department = department;
        this.position = position;
        this.specialty = specialty;
        this.experience = experience;
        this.education = education;
        this.graduateInstitutions = graduateInstitutions;
        this.tel = tel;
        this.email = email;
        this.detailExperience = detailExperience;
    }
    public Resume(String name, int age, String sex,   String specialty,  String education, String graduateInstitutions, int tel, String email, String detailExperience) {
        this.name = name;
        this.age = age;
        this.sex = sex;

        this.specialty = specialty;

        this.education = education;
        this.graduateInstitutions = graduateInstitutions;
        this.tel = tel;
        this.email = email;
        this.detailExperience = detailExperience;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetailExperience() {
        return detailExperience;
    }

    public void setDetailExperience(String detailExperience) {
        this.detailExperience = detailExperience;
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
        interviewStatus = interviewStatus;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                ", graduateInstitutions='" + graduateInstitutions + '\'' +
                ", tel=" + tel +
                ", email='" + email + '\'' +
                ", detailExperience='" + detailExperience + '\'' +
                ", checkStatus=" + checkStatus +
                ", InterviewStatus=" + interviewStatus +
                '}';
    }

}
