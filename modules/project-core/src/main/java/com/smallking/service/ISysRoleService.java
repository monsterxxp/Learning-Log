package com.smallking.service;

import com.smallking.common.TreeModel;
import com.smallking.dto.SysMenuDTO;
import com.smallking.dto.SysRoleDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.model.SysMenu;
import com.smallking.model.SysRole;

import java.util.List;

/**
* 描述：角色表 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/21
*/
public interface ISysRoleService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysRoleDTO findDTOById(String id)throws Exception;

    SysRoleDTO createSysRole(SysRoleDTO sysRoleDTO) throws Exception;

    SysRoleDTO updateSysRole(SysRoleDTO sysRoleDTO) throws Exception;

    IPage findSysRolePage(Page pageable, SysRoleDTO sysRoleDTO) throws Exception;

    void deleteById(String id) throws Exception;

    IPage findRoleByUserId(Page pageable, SysRoleDTO sysRoleDTO) throws Exception;

    List<TreeModel<SysMenu>> findAuthByRoleId(String id);

    List<TreeModel<SysMenu>> updateAuth(String id, List<String> menuIds) throws Exception;

    List<SysRole> findAll();

    void batchBulk(List<String> ids) throws Exception;
}
