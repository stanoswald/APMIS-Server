package com.stan.pojo;

public class Student {
    String no;
    String dormId;
    String regDate;
    String dept;
    String name;
    String tel;

    public Student(String no, String dormId, String regDate, String dept) {
        this.no = no;
        this.dormId = dormId;
        this.regDate = regDate;
        this.dept = dept;
    }

    public Student(String no, String dormId, String regDate, String dept, String name, String tel) {
        this.no = no;
        this.dormId = dormId;
        this.regDate = regDate;
        this.dept = dept;
        this.name = name;
        this.tel = tel;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", dormId='" + dormId + '\'' +
                ", regDate='" + regDate + '\'' +
                ", dept='" + dept + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
