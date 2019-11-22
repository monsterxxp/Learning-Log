package com.smallking.service;

import com.smallking.dto.SysRoleDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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

}
