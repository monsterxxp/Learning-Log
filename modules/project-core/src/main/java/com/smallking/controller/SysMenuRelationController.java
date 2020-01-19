package com.smallking.controller;

import com.smallking.service.ISysMenuRelationService;
import com.smallking.model.SysMenuRelation;
import com.smallking.dto.SysMenuRelationDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

/**
* 描述：权限关联表控制层
* @author WangShaoXiong
* @date 2019/11/26
*/
@RestController
@RequestMapping("/sysMenuRelation")
public class SysMenuRelationController {

    @Autowired
    private ISysMenuRelationService sysMenuRelationService;

    /**
    * 描述：根据Id 查询
    * @param id  权限关联表id
    */
    @GetMapping(value = "/{id}")
    public Return<SysMenuRelationDTO> findById(@PathVariable("id") String id) throws Exception {
        return Return.ok(sysMenuRelationService.findDTOById(id));
    }

    /**
    * 描述:创建权限关联表
    * @param sysMenuRelations  权限关联表DTO
    */
    @PostMapping(value = "/{id}")
    public Return<List<SysMenuRelation>> create(@PathVariable("id") String roleId, @RequestBody List<SysMenuRelation> sysMenuRelations) throws Exception {
        return Return.ok(sysMenuRelationService.batchCreateSysMenuRelation(roleId, sysMenuRelations));
    }

    /**
    * 描述：删除权限关联表
    * @param id 权限关联表id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysMenuRelationService.deleteById(id);
    }

    /**
    * 描述：更新权限关联表
    * @param id 权限关联表id
    */
    @PutMapping(value = "/{id}")
    public Return<SysMenuRelationDTO> updateSysMenuRelation(@PathVariable("id") String id,@RequestBody SysMenuRelationDTO sysMenuRelationDTO) throws Exception {
        sysMenuRelationDTO.setId(id);
        return Return.ok(sysMenuRelationService.updateSysMenuRelation(sysMenuRelationDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysMenuRelationDTO> query) throws Exception{
        SysMenuRelationDTO sysMenuRelationDTO = (SysMenuRelationDTO) query.getBean(SysMenuRelationDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysMenuRelationService.findSysMenuRelationPage(pageable, sysMenuRelationDTO);
        return Return.ok(page);
    }
}