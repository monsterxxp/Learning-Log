package com.smallking.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.system.UserInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.model.SysUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;
import com.smallking.model.SysUser;
import com.smallking.dto.SysUserDTO;
import com.smallking.service.ISysUserService;

import java.util.List;


/**
 * @description: 系统用户API
 * @author: smallking
 * @data: 2019-07-27 01:53
 **/
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping(value = "")
    public Return search(Query<SysUserDTO> query) {
        SysUserDTO sysUserDTO = (SysUserDTO) query.getBean(SysUserDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysUserService.findPage(pageable, sysUserDTO);
        return Return.page(page);
    }

    @PostMapping(value = "")
    public Return<SysUserDTO> create(@RequestBody SysUserDTO sysUserDTO) throws Exception{
        return Return.ok(sysUserService.create(sysUserDTO));
    }

    @GetMapping(value = "/{id}")
    public Return<SysUserDTO> findDTOById(@PathVariable String id) {
        return Return.ok(sysUserService.findDTOById(id));
    }

    @PutMapping(value = "/{id}")
    public Return<SysUser> update(@PathVariable String id, @RequestBody SysUserDTO sysUserDTO) throws Exception{
        sysUserDTO.setId(id);
        return Return.ok(sysUserService.update(sysUserDTO));
    }

    /**
     * 描述：刪除用户
     * @param id 用户id
     */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysUserService.deleteById(id);
    }

    /**
     * 描述：重置密码
     * @param id 用户id
     * @param sysUserDTO 用户DTO
     */
    @PutMapping(value = "/{id}/resetPwd")
    public Return<SysUser> resetPwd(@PathVariable("id") String id, @RequestBody SysUserDTO sysUserDTO) throws Exception {
        sysUserDTO.setId(id);
        return Return.ok(sysUserService.update(sysUserService.resetPwd(sysUserDTO)));
    }

    /**
     * 描述：批量刪除用户
     * @param ids 用户ids
     */
    @DeleteMapping(value = "/batchBulk")
    public void batchBulk(@RequestBody  List<String> ids) throws Exception {
        sysUserService.batchBulk(ids);
    }

    @GetMapping(value = "/info")
    public Return<SysUserInfo> findUserInfo() throws Exception {
        return Return.ok(sysUserService.findUserInfo());
    }

    @GetMapping(value = "/nav")
    public Return<JSONArray> nav(String token) throws Exception {
        return Return.ok(sysUserService.findNav(token));
    }
}
