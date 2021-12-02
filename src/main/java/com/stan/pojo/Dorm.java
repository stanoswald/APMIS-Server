package com.stan.pojo;

public class Dorm {
    Integer id;
    String apartment;
    String leader;
    String tel;
    String manager;

    public Dorm(Integer id, String apartment, String leader, String tel, String manager) {
        this.id = id;
        this.apartment = apartment;
        this.leader = leader;
        this.tel = tel;
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id='" + id + '\'' +
                ", apartment='" + apartment + '\'' +
                ", leader='" + leader + '\'' +
                ", tel='" + tel + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
