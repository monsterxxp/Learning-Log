package com.smallking.model;

import com.smallking.common.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @description: 角色用户关联
 * @author: smallking
 * @date: 2019-08-01
 **/
@Entity
@Table(name = "sys_role_relation")
public class SysRoleRelation extends BaseModel {

    @Column(name = "role_id", columnDefinition = "VARCHAR")
    private String roleId;

    @Column(name = "user_id", columnDefinition = "VARCHAR")
    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
