package com.stan.pojo;

public class Repair {
    String id;
    String dormId;
    String registrant;
    String propId;
    String detail;
    String fixDate;

    public Repair(String id, String dormId, String registrant, String propId, String detail, String fixDate) {
        this.id = id;
        this.dormId = dormId;
        this.registrant = registrant;
        this.propId = propId;
        this.detail = detail;
        this.fixDate = fixDate;
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

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getFixDate() {
        return fixDate;
    }

    public void setFixDate(String fixDate) {
        this.fixDate = fixDate;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id='" + id + '\'' +
                ", dormId='" + dormId + '\'' +
                ", registrant='" + registrant + '\'' +
                ", propId='" + propId + '\'' +
                ", detail='" + detail + '\'' +
                ", fixDate='" + fixDate + '\'' +
                '}';
    }
}
