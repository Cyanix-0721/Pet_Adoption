package com.pet_adoption.entity;

public class User {
    private int id;//用户id
    private String userName;//用户名
    private String userPwd;//用户密码
    private String sex;//性别
    private int age;//年龄
    private String telephone;//电话
    private String email;//邮箱
    private String address;//地址
    private String pic;//头像
    private int state;//领养宠物的经历

    public User(Integer id, String userName, String userPwd, String sex, Integer age, String telephone, String email, String address, String pic, Integer state) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.pic = pic;
        this.state = state;
    }

    public User(String userName, String userPwd, String sex, Integer age, String telephone, String email, String address, String pic, Integer state) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.pic = pic;
        this.state = state;
    }

    public User(Integer id, String userName, String userPwd, String sex, Integer age, String telephone, String email, String address, Integer state) {
        this.id = id;
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.state = state;
    }

    public User(String userName, String userPwd, String sex, Integer age, String telephone, String email, String address, Integer state) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.sex = sex;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.state = state;
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                '}';
    }
}
