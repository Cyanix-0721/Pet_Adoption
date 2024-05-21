package com.pet_adoption.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Reply {
    private int id;
    private int userId;
    private int replyId;
    private int commentId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replyTime;
    private String content;

    public Reply(int id, int userId, int replyId, int commentId, Date replyTime, String content) {
        this.id = id;
        this.userId = userId;
        this.replyId = replyId;
        this.commentId = commentId;
        this.replyTime = replyTime;
        this.content = content;
    }

    public Reply(int userId, int replyId, int commentId, Date replyTime, String content) {
        this.userId = userId;
        this.replyId = replyId;
        this.commentId = commentId;
        this.replyTime = replyTime;
        this.content = content;
    }

    public Reply(int id, int commentId, Date replyTime, String content) {
        this.id = id;
        this.commentId = commentId;
        this.replyTime = replyTime;
        this.content = content;
    }

    public Reply(int commentId, Date replyTime, String content) {
        this.commentId = commentId;
        this.replyTime = replyTime;
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

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
