package com.smallking.controller;

import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @program: learn
 * @description: 系统用户API
 * @author: smallking
 * @data: 2019-07-27 01:53
 **/
@RestController
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping(value = "/findAll")
    public List<SysUser> findAll() {
        return sysUserService.findAll();
    }

    @GetMapping(value = "/findAllByTemplate")
    public List<Map<String, Object>> findAllByTemplate() {
        return sysUserService.findAllByJdbcTemplate();
    }

    @GetMapping(value = "/findAllByJpa")
    public List<SysUser> findAllByJpa() {
        return sysUserService.findAllByJpa();
    }

    @GetMapping(value = "/findAllByMysql")
    public List<SysUser> findAllByMysql() {
        return sysUserService.findAllByMysql();
    }

    @PostMapping(value = "/create")
    public SysUser create() {
        return sysUserService.create();
    }

    @GetMapping(value = "/findById/{id}")
    public SysUser findById(@PathVariable("id") String id){
        return sysUserService.findById(id);
    }
}
