package com.pet_adoption.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Blog {
    private int id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date actionTime;
    private String address;
    private String peoples;
    private String event;
    private String title;

    public Blog(int id, Date actionTime, String address, String peoples, String event, String title) {
        this.id = id;
        this.actionTime = actionTime;
        this.address = address;
        this.peoples = peoples;
        this.event = event;
        this.title = title;
    }

    public Blog(Date actionTime, String address, String peoples, String event, String title) {
        this.actionTime = actionTime;
        this.address = address;
        this.peoples = peoples;
        this.event = event;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPeoples() {
        return peoples;
    }

    public void setPeoples(String peoples) {
        this.peoples = peoples;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
