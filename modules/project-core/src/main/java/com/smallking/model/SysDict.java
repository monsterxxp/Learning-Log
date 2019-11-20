package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：数据字典表模型
* @author WangShaoXiong
* @date 2019/11/16
*/
@Entity
@Table(name="sys_dict")
@Where(clause = "status > '0'")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class SysDict extends BaseModel implements CreateListenable, UpdateListenable, DeleteListenable {

    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;

    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "category_code",columnDefinition = "VARCHAR")
    private String categoryCode;

    @Column(name = "created_id",columnDefinition = "VARCHAR")
    private String createdId;

    @Column(name = "created_time",columnDefinition = "TIMESTAMP")
    private Date createdTime;

    @Column(name = "updated_id",columnDefinition = "VARCHAR")
    private String updatedId;

    @Column(name = "updated_time",columnDefinition = "TIMESTAMP")
    private Date updatedTime;

    @Column(name = "status",columnDefinition = "VARCHAR")
    private String status;

    @Column(name = "is_update",columnDefinition = "VARCHAR")
    private String isUpdate;

    @Column(name = "sort",columnDefinition = "NUMERIC")
    private Integer sort;

    @Column(name = "parent_id",columnDefinition = "VARCHAR")
    private String parentId;

    @Column(name = "description",columnDefinition = "VARCHAR")
    private String description;



    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCategoryCode() {
        return this.categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getIsUpdate() {
        return this.isUpdate;
    }

    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
