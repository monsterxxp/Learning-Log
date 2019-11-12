package com.smallking.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.annotation.Log;
import com.smallking.common.Query;
import com.smallking.common.Return;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @description: 系统用户API
 * @author: smallking
 * @data: 2019-07-27 01:53
 **/
@Api(value = "系统用户API")
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping(value = "")
    public Return<IPage> search(Query<SysUser> query) {
        SysUser sysUser = (SysUser) query.getBean(SysUser.class);
        Page pageable = query.getPageable();
        IPage page = sysUserService.findPage(pageable, sysUser);
        return Return.ok(page);
    }

    @PostMapping(value = "")
    public Return<SysUser> create(@RequestBody SysUser sysUser) {
        return Return.ok(sysUserService.create(sysUser));
    }

}
