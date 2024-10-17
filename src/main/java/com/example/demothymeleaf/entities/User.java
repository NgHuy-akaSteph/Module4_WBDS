package com.example.demothymeleaf.entities;

public class User {
    private int id;
    private String name;
    private boolean gender;
    private String email;
    private String password;
    private String address;

    public User() {
    }

    public User(int id, String name, boolean gender, String email, String password, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
