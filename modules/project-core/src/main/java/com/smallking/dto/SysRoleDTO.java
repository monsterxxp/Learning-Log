package com.smallking.dto;

import cn.hutool.json.JSONObject;
import com.smallking.model.SysRole;

import java.util.List;

/**
* 描述：角色表DTO
* @author WangShaoXiong
* @date 2019/11/21
*/
public class SysRoleDTO extends SysRole{

    private String userId;

    private List<JSONObject> permissions;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<JSONObject> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<JSONObject> permissions) {
        this.permissions = permissions;
    }
}
