package com.smallking.dto;

import com.smallking.model.SysRoleRelation;

/**
* 描述：角色关联表DTO
* @author WangShaoXiong
* @date 2019/11/24
*/
public class SysRoleRelationDTO extends SysRoleRelation{

    private String userName;

    private String roleName;

    private String roleCode;

    private String description;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
