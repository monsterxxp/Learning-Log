package com.smallking.controller;

import com.smallking.annotation.Log;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @description: 系统用户API
 * @author: smallking
 * @data: 2019-07-27 01:53
 **/
@Api(value = "系统用户API")
@RestController
@RequestMapping("/api/user")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;


}
