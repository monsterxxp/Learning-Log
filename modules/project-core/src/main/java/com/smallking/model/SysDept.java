package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：组织结构表模型
* @author WangShaoXiong
* @date 2019/11/16
*/
@Entity
@Table(name="sys_dept")
@Where(clause = "status > '0'")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class SysDept extends BaseModel implements CreateListenable, UpdateListenable, DeleteListenable {

    /**
    *部门名称
    */
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;


    /**
    *部门代号
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;


    /**
    *逻辑删
    */
    @Column(name = "status",columnDefinition = "VARCHAR")
    private String status;


    /**
    *创建人ID
    */
    @Column(name = "created_id",columnDefinition = "VARCHAR")
    private String createdId;


    /**
    *创建时间
    */
    @Column(name = "created_time",columnDefinition = "TIMESTAMP")
    private Date createdTime;


    /**
    *修改人ID
    */
    @Column(name = "updated_id",columnDefinition = "VARCHAR")
    private String updatedId;


    /**
    *修改时间
    */
    @Column(name = "updated_time",columnDefinition = "TIMESTAMP")
    private Date updatedTime;


    /**
    *排序
    */

    @Column(name = "sort",columnDefinition = "NUMERIC")
    private Integer sort;

    /**
    *负责人
    */
    @Column(name = "leader_id",columnDefinition = "VARCHAR")
    private String leaderId;


    /**
    *联系电话
    */
    @Column(name = "contact_phone",columnDefinition = "VARCHAR")
    private String contactPhone;


    /**
    *描述
    */
    @Column(name = "description",columnDefinition = "VARCHAR")
    private String description;

    /**
     *上级部门ID
     */
    @Column(name = "parent_id",columnDefinition = "VARCHAR")
    private String parentId;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getCreatedId() {
        return this.createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }


    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public String getUpdatedId() {
        return this.updatedId;
    }

    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }


    public Date getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }



    public Integer getSort() {
    return this.sort;
    }

    public void setSort(Integer sort) {
    this.sort = sort;
    }

    public String getLeaderId() {
        return this.leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }


    public String getContactPhone() {
        return this.contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
