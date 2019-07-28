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

    @GetMapping(value = "/findAllByJPA")
    public List<SysUser> findAllByJPA() {
        return sysUserService.findAllByJPA();
    }

    @GetMapping(value = "/findAll")
    public List<SysUser> findAll() {
        return sysUserService.findAll();
    }
}
