package com.pet_adoption.entity;


public class Admin {
    private int id; // 管理员编号
    private String adminName; // 管理员用户名
    private String adminPwd; // 管理员密码
    private String realName; // 管理员真实姓名
    private String sex; // 管理员性别
    private int age; // 管理员年龄
    private String telephone; // 管理员电话
    private String email; // 管理员邮箱
    private String pic; // 管理员头像
    private String remark; // 管理员备注

    public Admin(int id, String adminName, String adminPwd, String realName, String telephone, String email, int age, String sex, String pic, String remark) {
        this.id = id;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.realName = realName;
        this.telephone = telephone;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.pic = pic;
        this.remark = remark;
    }

    public Admin(String adminName, String adminPwd, String realName, String telephone, String email, int age, String sex, String pic, String remark) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.realName = realName;
        this.telephone = telephone;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.pic = pic;
        this.remark = remark;
    }

    public Admin(int id, String adminName, String adminPwd, String realName, String telephone, String email) {
        this.id = id;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.realName = realName;
        this.telephone = telephone;
        this.email = email;
    }

    public Admin(String adminName, String adminPwd, String realName, String telephone, String email) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.realName = realName;
        this.telephone = telephone;
        this.email = email;
    }

    public Admin(String adminName, String adminPwd) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
    }

    public Admin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", realName='" + realName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", pic='" + pic + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
