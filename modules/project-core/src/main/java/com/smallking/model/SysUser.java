package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @program: learn
 * @description: 系统用户类
 * @author: smallking
 * @data: 2019-07-27 01:41
 **/
@Entity
@Table(name = "sys_user")
public class SysUser extends BaseModel implements CreateListenable, UpdateListenable, DeleteListenable {


    @Column(name = "name", columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "account", columnDefinition = "VARCHAR")
    private String account;

    @Column(name = "password", columnDefinition = "VARCHAR")
    private String password;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP")
    private Date createdTime;

    @Column(name = "updated_time", columnDefinition = "TIMESTAMP")
    private Date updatedTime;

    @Column(name = "status", columnDefinition = "VARCHAR")
    private String status;

    @Column(name = "sex", columnDefinition = "VARCHAR")
    private String sex;

    @Column(name = "mobile", columnDefinition = "VARCHAR")
    private String mobile;

    @Column(name = "email", columnDefinition = "VARCHAR")
    private String email;

    @Column(name = "dept_id", columnDefinition = "VARCHAR")
    private String deptId;

    @Column(name = "post_id", columnDefinition = "VARCHAR")
    private String postId;

    @Column(name = "description", columnDefinition = "VARCHAR")
    private String description;

    @Column(name = "salt", columnDefinition = "VARCHAR")
    private String salt;

    @Column(name = "user_status", columnDefinition = "VARCHAR")
    private String userStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Date getCreatedTime() {
        return createdTime;
    }

    @Override
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public Date getUpdatedTime() {
        return updatedTime;
    }

    @Override
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
