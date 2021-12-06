package com.stan.pojo;

public class PropReg {
    String id;
    String dormId;
    String propId;
    String registrant;
    String regType;
    String stat;

    public PropReg(String id, String dormId, String propId, String registrant, String regType, String stat) {
        this.id = id;
        this.dormId = dormId;
        this.propId = propId;
        this.registrant = registrant;
        this.regType = regType;
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

    public String getPropId() {
        return propId;
    }

    public void setPropId(String propId) {
        this.propId = propId;
    }

    public String getRegistrant() {
        return registrant;
    }

    public void setRegistrant(String registrant) {
        this.registrant = registrant;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "PropReg{" +
                "id='" + id + '\'' +
                ", dormId='" + dormId + '\'' +
                ", propId='" + propId + '\'' +
                ", registrant='" + registrant + '\'' +
                ", regType='" + regType + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
