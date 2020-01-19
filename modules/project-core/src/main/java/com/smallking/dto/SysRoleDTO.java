package com.smallking.dto;

import com.smallking.model.SysPermission;
import com.smallking.model.SysRole;

import java.util.List;

/**
* 描述：角色表DTO
* @author WangShaoXiong
* @date 2019/11/21
*/
public class SysRoleDTO extends SysRole{

    private String userId;

    private List<SysPermission> permissions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }
}
