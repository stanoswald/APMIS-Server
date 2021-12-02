package com.stan.pojo;

public class User {
    private String username;
    private String password;
    private Integer roleId;

    private String name;
    private String tel;
    private String email;

    public User(String username, String password, Integer role_id) {

        this.username = username;
        this.password = password;
        this.roleId = role_id;
    }

    public User(String username, String password, Integer roleId, String name, String tel, String email) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.name = name;
        this.tel = tel;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
