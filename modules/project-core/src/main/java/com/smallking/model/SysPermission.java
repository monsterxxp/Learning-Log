package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.UpdateListenable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description: 权限
 * @author: smallking
 * @date: 2019-08-01
 **/
@Entity
@Table(name = "sys_permission")
public class SysPermission extends BaseModel implements CreateListenable, UpdateListenable {

    @Column(name = "name", columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "code", columnDefinition = "VARCHAR")
    private String code;

    @Column(name = "description", columnDefinition = "VARCHAR")
    private String description;

    @Column(name = "created_time", columnDefinition = "TIMESTAMP")
    private Date createdTime;

    @Column(name = "updated_time", columnDefinition = "TIMESTAMP")
    private Date updatedTime;

    @Column(name = "parent_id", columnDefinition = "VARCHAR")
    private String parentId;

    @Column(name = "url", columnDefinition = "VARCHAR")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
