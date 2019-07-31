package com.smallking.model;

import com.smallking.common.BaseModel;

import javax.persistence.Column;

/**
 * @description: 角色权限关联
 * @author: smallking
 * @date: 2019-08-01
 **/
public class SysRolePermission extends BaseModel {

    @Column(name = "role_id", columnDefinition = "VARCHAR")
    private String roleId;

    @Column(name = "permission_id", columnDefinition = "VARCHAR")
    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
