package com.smallking.dto;

import com.smallking.model.SysMenu;

import java.util.List;

/**
* 描述：菜单表DTO
* @author WangShaoXiong
* @date 2019/11/21
*/
public class SysMenuDTO extends SysMenu {

    private List<SysMenuDTO> children;

    public List<SysMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuDTO> children) {
        this.children = children;
    }
}
