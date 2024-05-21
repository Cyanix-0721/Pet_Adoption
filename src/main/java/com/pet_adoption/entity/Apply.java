package com.pet_adoption.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Apply {
    private int id;
    private String name;
    private String email;
    private int age;
    private String telephone;
    private String message;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date applyTime;
    private int state;

    public Apply(int id, String name, String email, int age, String telephone, String message, Date applyTime, int state) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.telephone = telephone;
        this.message = message;
        this.applyTime = applyTime;
        this.state = state;
    }

    public Apply(String name, String email, int age, String telephone, String message, Date applyTime, int state) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.telephone = telephone;
        this.message = message;
        this.applyTime = applyTime;
        this.state = state;
    }

    public Apply(int id, String name, String email, int age, String telephone, String message, Date applyTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.telephone = telephone;
        this.message = message;
        this.applyTime = applyTime;
    }

    public Apply(String name, String email, int age, String telephone, String message, Date applyTime) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.telephone = telephone;
        this.message = message;
        this.applyTime = applyTime;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
