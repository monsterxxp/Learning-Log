package com.smallking.controller;

import com.smallking.common.TreeModel;
import com.smallking.service.ISysMenuService;
import com.smallking.model.SysMenu;
import com.smallking.dto.SysMenuDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

/**
* 描述：菜单表控制层
* @author WangShaoXiong
* @date 2019/11/21
*/
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {

    @Autowired
    private ISysMenuService sysMenuService;

    /**
    * 描述：根据Id 查询
    * @param id  菜单表id
    */
    @GetMapping(value = "/{id}")
    public Return<SysMenuDTO> findById(@PathVariable("id") String id) throws Exception {
        return Return.ok(sysMenuService.findDTOById(id));
    }

    /**
    * 描述:创建菜单表
    * @param sysMenuDTO  菜单表DTO
    */
    @PostMapping(value = "")
    public Return<SysMenuDTO> create(@RequestBody SysMenuDTO sysMenuDTO) throws Exception {
        return Return.ok(sysMenuService.createSysMenu(sysMenuDTO));
    }

    /**
    * 描述：删除菜单表
    * @param id 菜单表id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysMenuService.deleteById(id);
    }

    /**
    * 描述：更新菜单表
    * @param id 菜单表id
    */
    @PutMapping(value = "/{id}")
    public Return<SysMenuDTO> updateSysMenu(@PathVariable("id") String id,@RequestBody SysMenuDTO sysMenuDTO) throws Exception {
        sysMenuDTO.setId(id);
        return Return.ok(sysMenuService.updateSysMenu(sysMenuDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysMenuDTO> query) throws Exception{
        SysMenuDTO sysMenuDTO = (SysMenuDTO) query.getBean(SysMenuDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysMenuService.findSysMenuPage(pageable, sysMenuDTO);
        return Return.ok(page);
    }

    /**
     * 菜单树
     * @param query
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/tree")
    public Return<List<TreeModel<SysMenuDTO>>> tree(Query<SysMenuDTO> query) throws Exception{
        SysMenuDTO sysMenuDTO = (SysMenuDTO) query.getBean(SysMenuDTO.class);
        List<TreeModel<SysMenuDTO>>  trees = sysMenuService.findTree(sysMenuDTO);
        return Return.ok(trees);
    }
}