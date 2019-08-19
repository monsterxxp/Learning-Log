package com.smallking.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
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
public class SysUser extends BaseModel implements CreateListenable, UpdateListenable {


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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
