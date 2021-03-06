package com.smallking.controller;

import com.smallking.common.TreeModel;
import com.smallking.dto.SysMenuDTO;
import com.smallking.model.SysMenu;
import com.smallking.service.ISysRoleService;
import com.smallking.model.SysRole;
import com.smallking.dto.SysRoleDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

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
     * 描述：批量刪除角色
     * @param ids 用户ids
     */
    @DeleteMapping(value = "/batchBulk")
    public void batchBulk(@RequestBody  List<String> ids) throws Exception {
        sysRoleService.batchBulk(ids);
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
    public Return search(Query<SysRoleDTO> query) throws Exception{
        SysRoleDTO sysRoleDTO = (SysRoleDTO) query.getBean(SysRoleDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysRoleService.findSysRolePage(pageable, sysRoleDTO);
        return Return.page(page);
    }

    /**
     * 获取所有角色
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/findAll")
    public Return<List<SysRole>> findAll() throws Exception{
        List<SysRole> roles = sysRoleService.findAll();
        return Return.ok(roles);
    }

    /**
     * 查询指定用户所能关联的角色
     * @param query
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/findRoleByUserId")
    public Return<IPage> findRoleByUserId(Query<SysRoleDTO> query) throws Exception{
        SysRoleDTO sysRoleDTO = (SysRoleDTO) query.getBean(SysRoleDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysRoleService.findRoleByUserId(pageable, sysRoleDTO);
        return Return.ok(page);
    }

    /**
     * 菜单树
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/{id}/findAuthByRoleId")
    public Return<List<TreeModel<SysMenu>>> findAuthByRoleId(@PathVariable("id") String id) throws Exception{
        List<TreeModel<SysMenu>>  trees = sysRoleService.findAuthByRoleId(id);
        return Return.ok(trees);
    }

    /**
     * 描述：更新角色数据权限
     * @param id 角色id
     * @param menuIds 菜单Id列表
     */
    @PutMapping(value = "/{id}/updateAuth")
    public Return<List<TreeModel<SysMenu>>> updateAuth(@PathVariable("id") String id,@RequestBody List<String> menuIds) throws Exception {
        return Return.ok(sysRoleService.updateAuth(id, menuIds));
    }
}