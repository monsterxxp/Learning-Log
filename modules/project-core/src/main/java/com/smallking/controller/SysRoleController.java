package com.smallking.controller;

import com.smallking.service.ISysRoleService;
import com.smallking.model.SysRole;
import com.smallking.dto.SysRoleDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

/**
* 描述：角色表控制层
* @author WangShaoXiong
* @date 2019/11/21
*/
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;

    /**
    * 描述：根据Id 查询
    * @param id  角色表id
    */
    @GetMapping(value = "/{id}")
    public Return<SysRoleDTO> findById(@PathVariable("id") String id) throws Exception {
        return Return.ok(sysRoleService.findDTOById(id));
    }

    /**
    * 描述:创建角色表
    * @param sysRoleDTO  角色表DTO
    */
    @PostMapping(value = "")
    public Return<SysRoleDTO> create(@RequestBody SysRoleDTO sysRoleDTO) throws Exception {
        return Return.ok(sysRoleService.createSysRole(sysRoleDTO));
    }

    /**
    * 描述：删除角色表
    * @param id 角色表id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysRoleService.deleteById(id);
    }

    /**
    * 描述：更新角色表
    * @param id 角色表id
    */
    @PutMapping(value = "/{id}")
    public Return<SysRoleDTO> updateSysRole(@PathVariable("id") String id,@RequestBody SysRoleDTO sysRoleDTO) throws Exception {
        sysRoleDTO.setId(id);
        return Return.ok(sysRoleService.updateSysRole(sysRoleDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysRoleDTO> query) throws Exception{
        SysRoleDTO sysRoleDTO = (SysRoleDTO) query.getBean(SysRoleDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysRoleService.findSysRolePage(pageable, sysRoleDTO);
        return Return.ok(page);
    }
}