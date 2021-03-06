package com.smallking.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smallking.model.SysUser;

import java.util.List;

/**
 * @description: 系统用户DTO
 * @author: smallking
 * @date: 2019-07-31
 **/
public class SysUserDTO extends SysUser {

    @JsonIgnore
    private String password;

    private String deptName;

    private String token;

    private List<String> roleIds;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
