package com.pet_adoption.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Comments {
    public int id;
    public int userId;
    public int adminId;
    public int petId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date commentTime;
    public String content;

    public Comments(int id, int userId, int adminId, int petId, Date commentTime, String content) {
        this.id = id;
        this.userId = userId;
        this.adminId = adminId;
        this.petId = petId;
        this.commentTime = commentTime;
        this.content = content;
    }

    public Comments(int id, Date commentTime, String content) {
        this.id = id;
        this.commentTime = commentTime;
        this.content = content;
    }

    public Comments(Date commentTime, String content) {
        this.commentTime = commentTime;
        this.content = content;
    }

    public Comments(int userId, int adminId, int petId, Date commentTime, String content) {
        this.userId = userId;
        this.adminId = adminId;
        this.petId = petId;
        this.commentTime = commentTime;
        this.content = content;
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

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
