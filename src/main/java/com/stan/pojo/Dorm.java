package com.stan.pojo;

public class Dorm {
    private Integer dormId;
    private String leaderNo;
    private String tel;

    public Dorm(Integer dormId, String leaderNo, String tel) {
        this.dormId = dormId;
        this.leaderNo = leaderNo;
        this.tel = tel;
    }

    public Integer getDormId() {
        return dormId;
    }

    public void setDormId(Integer dormId) {
        this.dormId = dormId;
    }

    public String getLeaderNo() {
        return leaderNo;
    }

    public void setLeaderNo(String leaderNo) {
        this.leaderNo = leaderNo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "dormId=" + dormId +
                ", leaderNo=" + leaderNo +
                ", tel='" + tel + '\'' +
                '}';
    }
}
