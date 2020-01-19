package com.smallking.model;

import com.smallking.dto.SysMenuDTO;
import com.smallking.dto.SysRoleDTO;
import com.smallking.dto.SysUserDTO;

import java.util.List;

public class SysUserInfo extends SysUser{

    private SysRoleDTO role;

    public SysRoleDTO getRole() {
        return role;
    }

    public void setRole(SysRoleDTO role) {
        this.role = role;
    }
}
