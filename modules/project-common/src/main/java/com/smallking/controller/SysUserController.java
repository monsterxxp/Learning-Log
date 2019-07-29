package com.smallking.controller;

import com.smallking.annotation.Log;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

/**
 * @program: learn
 * @description: 系统用户API
 * @author: smallking
 * @data: 2019-07-27 01:53
 **/
@Api(value = "系统用户API")
@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @ApiIgnore
    @Log("123")
    @GetMapping(value = "/findAllByJPA")
    public List<SysUser> findAllByJPA() {
        return sysUserService.findAllByJPA();
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @Log("123")
    @GetMapping(value = "/findAll")
    public List<SysUser> findAll() {
        return sysUserService.findAll();
    }

    @ApiIgnore
    @Log("123")
    @GetMapping(value = "/create")
    public SysUser create() {
        return sysUserService.create();
    }

    @ApiIgnore
    @Log("根据用户ID查询用户")
    @GetMapping(value = "/findById")
    public SysUser findById(String id) {
        return sysUserService.findById(id);
    }
}
