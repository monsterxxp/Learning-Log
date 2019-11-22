package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：角色表模型
* @author WangShaoXiong
* @date 2019/11/21
*/
@Entity
@Table(name="sys_role")
@Where(clause = "status > '0'")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class SysRole extends BaseModel implements CreateListenable, UpdateListenable, DeleteListenable {

    /**
    *角色名称
    */
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;


    /**
    *说明
    */
    @Column(name = "description",columnDefinition = "VARCHAR")
    private String description;


    /**
    *创建时间
    */
    @Column(name = "created_time",columnDefinition = "TIMESTAMP")
    private Date createdTime;


    /**
    *修改时间
    */
    @Column(name = "updated_time",columnDefinition = "TIMESTAMP")
    private Date updatedTime;


    /**
    *角色代码
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;


    /**
    *创建人ID
    */
    @Column(name = "created_id",columnDefinition = "VARCHAR")
    private String createdId;


    /**
    *修改人ID
    */
    @Column(name = "updated_id",columnDefinition = "VARCHAR")
    private String updatedId;


    /**
    *逻辑删
    */
    @Column(name = "status",columnDefinition = "VARCHAR")
    private String status;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Date getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    public Date getUpdatedTime() {
        return this.updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }


    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getCreatedId() {
        return this.createdId;
    }

    public void setCreatedId(String createdId) {
        this.createdId = createdId;
    }


    public String getUpdatedId() {
        return this.updatedId;
    }

    public void setUpdatedId(String updatedId) {
        this.updatedId = updatedId;
    }


    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
