package com.smallking.controller;

import com.smallking.service.ISysRoleRelationService;
import com.smallking.model.SysRoleRelation;
import com.smallking.dto.SysRoleRelationDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

/**
* 描述：角色关联表控制层
* @author WangShaoXiong
* @date 2019/11/24
*/
@RestController
@RequestMapping("/sysRoleRelation")
public class SysRoleRelationController {

    @Autowired
    private ISysRoleRelationService sysRoleRelationService;

    /**
    * 描述：根据Id 查询
    * @param id  角色关联表id
    */
    @GetMapping(value = "/{id}")
    public Return<SysRoleRelationDTO> findById(@PathVariable("id") String id) throws Exception {
        return Return.ok(sysRoleRelationService.findDTOById(id));
    }

    /**
    * 描述:创建角色关联表
    * @param sysRoleRelations  角色关联表DTO
    */
    @PostMapping(value = "")
    public Return<List<SysRoleRelation>> create(@RequestBody List<SysRoleRelation> sysRoleRelations) throws Exception {
        return Return.ok(sysRoleRelationService.batchSysRoleRelation(sysRoleRelations));
    }

    /**
    * 描述：删除角色关联表
    * @param id 角色关联表id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysRoleRelationService.deleteById(id);
    }

    /**
    * 描述：更新角色关联表
    * @param id 角色关联表id
    */
    @PutMapping(value = "/{id}")
    public Return<SysRoleRelationDTO> updateSysRoleRelation(@PathVariable("id") String id,@RequestBody SysRoleRelationDTO sysRoleRelationDTO) throws Exception {
        sysRoleRelationDTO.setId(id);
        return Return.ok(sysRoleRelationService.updateSysRoleRelation(sysRoleRelationDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysRoleRelationDTO> query) throws Exception{
        SysRoleRelationDTO sysRoleRelationDTO = (SysRoleRelationDTO) query.getBean(SysRoleRelationDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysRoleRelationService.findSysRoleRelationPage(pageable, sysRoleRelationDTO);
        return Return.ok(page);
    }

    /**
     * 查询角色关联关系列表
     * @param query
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/findRoleRelation")
    public Return<List<SysRoleRelationDTO>> findRoleRelation(Query<SysRoleRelationDTO> query) throws Exception{
        SysRoleRelationDTO sysRoleRelationDTO = (SysRoleRelationDTO) query.getBean(SysRoleRelationDTO.class);
        List<SysRoleRelationDTO> list = sysRoleRelationService.findRoleRelation(sysRoleRelationDTO);
        return Return.ok(list);
    }

}