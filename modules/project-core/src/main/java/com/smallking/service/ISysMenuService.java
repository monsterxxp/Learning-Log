package com.smallking.service;

import com.smallking.dto.SysMenuDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* 描述：菜单表 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/21
*/
public interface ISysMenuService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysMenuDTO findDTOById(String id)throws Exception;

    SysMenuDTO createSysMenu(SysMenuDTO sysMenuDTO) throws Exception;

    SysMenuDTO updateSysMenu(SysMenuDTO sysMenuDTO) throws Exception;

    IPage findSysMenuPage(Page pageable, SysMenuDTO sysMenuDTO) throws Exception;

    void deleteById(String id) throws Exception;

}
