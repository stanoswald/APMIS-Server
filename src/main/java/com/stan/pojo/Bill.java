package com.stan.pojo;

public class Bill {
    String id;
    String dormId;
    String detail;
    String billDate;
    String registrant;
    String stat;

    public Bill(String id, String dormId, String detail, String billDate, String registrant, String stat) {
        this.id = id;
        this.dormId = dormId;
        this.detail = detail;
        this.billDate = billDate;
        this.registrant = registrant;
        this.stat = stat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDormId() {
        return dormId;
    }

    public void setDormId(String dormId) {
        this.dormId = dormId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", dormId='" + dormId + '\'' +
                ", detail='" + detail + '\'' +
                ", billDate='" + billDate + '\'' +
                ", registrant='" + registrant + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
