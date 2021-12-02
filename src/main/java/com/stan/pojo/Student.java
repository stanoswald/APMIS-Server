package com.stan.pojo;

public class Student{
    private String no;
    private String dormId;
    private String regDate;
    private Integer deptNo;
    private String name;
    private String tel;

    public Student(String no, String dormId, String regDate, Integer deptNo) {
        this.no = no;
        this.dormId = dormId;
        this.regDate = regDate;
        this.deptNo = deptNo;
    }

    public Student(String no, String dormId, String regDate, Integer deptNo, String name, String tel) {
        this.no = no;
        this.dormId = dormId;
        this.regDate = regDate;
        this.deptNo = deptNo;
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

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
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
                ", deptNo=" + deptNo +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
