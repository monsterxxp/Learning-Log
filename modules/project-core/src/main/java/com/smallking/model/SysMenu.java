package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：菜单表模型
* @author WangShaoXiong
* @date 2019/11/21
*/
@Entity
@Table(name="sys_menu")
@Where(clause = "status > '0'")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class SysMenu extends BaseModel implements CreateListenable, UpdateListenable, DeleteListenable {

    /**
    *菜单名称
    */
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;


    /**
    *菜单代码
    */
    @Column(name = "code",columnDefinition = "VARCHAR")
    private String code;


    /**
    *菜单图标
    */
    @Column(name = "icon",columnDefinition = "VARCHAR")
    private String icon;


    /**
    *菜单链接
    */
    @Column(name = "menu_url",columnDefinition = "VARCHAR")
    private String menuUrl;


    /**
    *父级ID
    */
    @Column(name = "parent_id",columnDefinition = "VARCHAR")
    private String parentId;


    /**
    *排序
    */

    @Column(name = "sort",columnDefinition = "INTEGER")
    private Integer sort;

    /**
    *逻辑删
    */
    @Column(name = "status",columnDefinition = "VARCHAR")
    private String status;


    /**
    *菜单类别
    */
    @Column(name = "menu_type",columnDefinition = "VARCHAR")
    private String menuType;


    /**
    *
    */
    @Column(name = "auth_code",columnDefinition = "VARCHAR")
    private String authCode;


    /**
    *组件路径
    */
    @Column(name = "component",columnDefinition = "VARCHAR")
    private String component;


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
    *修改人id
    */
    @Column(name = "updated_id",columnDefinition = "VARCHAR")
    private String updatedId;


    /**
    *修改时间
    */
    @Column(name = "updated_time",columnDefinition = "TIMESTAMP")
    private Date updatedTime;

    /**
     *是否外链
     */
    @Column(name = "is_frame",columnDefinition = "VARCHAR")
    private String isFrame;

    /**
     *是否可见
     */
    @Column(name = "is_hidden",columnDefinition = "VARCHAR")
    private String isHidden;

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

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuUrl() {
        return this.menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }


    public String getAuthCode() {
        return this.authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }


    public String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
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

    public String getIsFrame() {
        return isFrame;
    }

    public void setIsFrame(String isFrame) {
        this.isFrame = isFrame;
    }

    public String getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(String isHidden) {
        this.isHidden = isHidden;
    }
}
