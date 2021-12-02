package com.stan.pojo;

public class Visitor {
    String id;
    String name;
    String detail;
    String registrant;
    String startTime;
    String endTime;
    String stat;

    public Visitor(String id, String name, String detail, String registrant, String startTime, String endTime, String stat) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.registrant = registrant;
        this.startTime = startTime;
        this.endTime = endTime;
        this.stat = stat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", registrant='" + registrant + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
