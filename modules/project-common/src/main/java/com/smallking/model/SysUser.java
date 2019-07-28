package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.UpdateListenable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
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

    @Column(name = "create_time", columnDefinition = "TIMESTAMP")
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "TIMESTAMP")
    private Date updateTime;

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
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
