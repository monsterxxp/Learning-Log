package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.UpdateListenable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 角色
 * @author: smallking
 * @date: 2019-08-01
 **/
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseModel implements CreateListenable, UpdateListenable {

    @Column(name = "name", columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "code", columnDefinition = "VARCHAR")
    private String code;

    @Column(name = "description", columnDefinition = "VARCHAR")
    private String description;

    @Column(name = "created_id", columnDefinition = "VARCHAR")
    private String createdId;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP")
    private Date createdTime;

    @Column(name = "updated_id", columnDefinition = "VARCHAR")
    private String updatedId;

    @Column(name = "updated_time", columnDefinition = "TIMESTAMP")
    private Date updatedTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCreatedId() {
        return createdId;
    }

    @Override
    public void setCreatedId(String createdId) {
        this.createdId = createdId;
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
    public String getUpdatedId() {
        return updatedId;
    }

    @Override
    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }

    @Override
    public Date getUpdatedTime() {
        return updatedTime;
    }

    @Override
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
