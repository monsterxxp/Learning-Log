package com.smallking.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.smallking.common.BizException;
import com.smallking.common.Return;
import com.smallking.dto.SysUserDTO;
import com.smallking.model.SysMenu;
import com.smallking.model.SysUser;
import com.smallking.service.ISysMenuService;
import com.smallking.service.ISysUserService;
import com.smallking.utils.TokenUtil;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 用户认证
 * @author: smallking
 * @date: 2019-07-31
 **/
@Api(value = "用户认证")
@Controller
//@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ISysMenuService sysMenuService;

    @Autowired
    private ISysUserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Return<SysUserDTO> login(@RequestBody SysUser sysUser) {
//        password = DigestUtil.md5Hex(password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getAccount(), sysUser.getPassword());
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            //验证成功，获取用户信息
            SysUserDTO userInfo = userService.findByAccount(sysUser.getAccount());
            //生成Token
            String token = TokenUtil.sign(userInfo.getAccount(), userInfo.getId());
            userInfo.setToken(token);
            return Return.ok(userInfo);
        } catch (UnknownAccountException e) {
            usernamePasswordToken.clear();
            throw new BizException("验证未通过,用户不存在");
        } catch (LockedAccountException lae) {
            usernamePasswordToken.clear();
            throw new BizException("验证未通过,账户已锁定");
        } catch (ExcessiveAttemptsException e) {
            usernamePasswordToken.clear();
            throw new BizException("验证未通过,错误次数过多");
        } catch (AuthenticationException e) {
            usernamePasswordToken.clear();
            throw new BizException("密码错误");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public @ResponseBody Return<Void> logout() {
        Session session = SecurityUtils.getSubject().getSession();
        session.removeAttribute("USER_SESSION");
        return Return.ok();
    }
}
