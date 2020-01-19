package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：权限关联表模型
* @author WangShaoXiong
* @date 2019/11/26
*/
@Entity
@Table(name="sys_menu_relation")
public class SysMenuRelation extends BaseModel {

    /**
    *角色id
    */
    @Column(name = "role_id",columnDefinition = "VARCHAR")
    private String roleId;


    /**
    *菜单id
    */
    @Column(name = "menu_id",columnDefinition = "VARCHAR")
    private String menuId;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }



}
