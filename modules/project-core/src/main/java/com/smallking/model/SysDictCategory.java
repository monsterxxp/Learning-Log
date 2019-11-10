package com.smallking.model;
import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：会议室预订模型
* @author WangShaoXiong
* @date 2019/11/10
*/
@Entity
@Table(name="sys_dict_category")
@Where(clause = "status > '0'")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class SysDictCategory extends BaseModel implements CreateListenable, UpdateListenable {

    /**
    *
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;


    /**
    *
    */
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;


    /**
    *
    */
    @Column(name = "created_time",columnDefinition = "TIMESTAMP")
    private Date createdTime;


    /**
    *
    */
    @Column(name = "updated_time",columnDefinition = "TIMESTAMP")
    private Date updatedTime;


    /**
    *
    */
    @Column(name = "status",columnDefinition = "VARCHAR")
    private String status;


    /**
    *
    */
    @Column(name = "is_update",columnDefinition = "VARCHAR")
    private String isUpdate;


    /**
    *
    */
    @Column(name = "created_id",columnDefinition = "VARCHAR")
    private String createdId;


    /**
    *
    */
    @Column(name = "updated_id",columnDefinition = "VARCHAR")
    private String updatedId;


    /**
    *
    */
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


    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
