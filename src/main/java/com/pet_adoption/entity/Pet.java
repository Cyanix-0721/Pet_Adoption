package com.pet_adoption.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Pet {
    private int id;//宠物的id
    private String petName;//宠物的名称
    private String petType;//宠物的类型
    private String sex;//宠物的性别
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;//宠物的出生日期
    private String pic;//图片
    private int state;//领养状态
    private String remark;//备注

    public Pet(int id, String petName, String petType, String sex, Date birthday, String pic, int state, String remark) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.sex = sex;
        this.birthday = birthday;
        this.pic = pic;
        this.state = state;
        this.remark = remark;
    }

    public Pet(String petName, String petType, String sex, Date birthday, String pic, int state, String remark) {
        this.petName = petName;
        this.petType = petType;
        this.sex = sex;
        this.birthday = birthday;
        this.pic = pic;
        this.state = state;
        this.remark = remark;
    }

    public Pet(int id, String petName, String petType, String sex, Date birthday, int state) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.sex = sex;
        this.birthday = birthday;
        this.state = state;
    }

    public Pet(String petName, String petType, String sex, Date birthday, int state) {
        this.petName = petName;
        this.petType = petType;
        this.sex = sex;
        this.birthday = birthday;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}