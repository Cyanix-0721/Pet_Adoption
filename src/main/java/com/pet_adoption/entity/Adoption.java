package com.pet_adoption.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Adoption {
    public int id;
    public int userId;
    public int petId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date adoptTime;
    public int state;//0:拒绝，1：同意 2:待处理

    public Adoption(int id, int userId, int petId, Date adoptTime, int state) {
        this.id = id;
        this.userId = userId;
        this.petId = petId;
        this.adoptTime = adoptTime;
        this.state = state;
    }

    public Adoption(int userId, int petId, Date adoptTime, int state) {
        this.userId = userId;
        this.petId = petId;
        this.adoptTime = adoptTime;
        this.state = state;
    }

    public Adoption(int id, int userId, int petId, Date adoptTime) {
        this.id = id;
        this.userId = userId;
        this.petId = petId;
        this.adoptTime = adoptTime;
    }

    public Adoption(int userId, int petId, Date adoptTime) {
        this.userId = userId;
        this.petId = petId;
        this.adoptTime = adoptTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public Date getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Date adoptTime) {
        this.adoptTime = adoptTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

