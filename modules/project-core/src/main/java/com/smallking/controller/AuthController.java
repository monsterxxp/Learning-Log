package com.smallking.controller;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.smallking.common.Return;
import com.smallking.model.SysUser;
import com.smallking.model.dto.SysUserDTO;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 用户认证
 * @author: smallking
 * @date: 2019-07-31
 **/
@Api(value = "用户认证")
@Controller
//@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Return<SysUserDTO> login(String username, String password, Boolean rememberMe) {
        password = DigestUtil.md5Hex(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Return.ok();
        } catch (UnknownAccountException e) {
            return Return.error(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Return.error(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        } catch (LockedAccountException e) {
            return Return.error(HttpStatus.UNAUTHORIZED.value(), e.getMessage());
        } catch (AuthenticationException e) {
            return Return.error(HttpStatus.UNAUTHORIZED.value(), "认证失败！");
        }
    }
    @RequiresPermissions("list:view")
    @RequestMapping("list")
    public String userList(Model model) {
        model.addAttribute("value", "获取用户信息");
        return "user";
    }
    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
