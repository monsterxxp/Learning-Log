package com.smallking.controller;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.MD5;
import com.smallking.common.BizException;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody Return<SysUserDTO> login(String username, String password, boolean rememberMe) {
        password = DigestUtil.md5Hex(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Return.ok();
        } catch (UnknownAccountException e) {
            token.clear();
            throw new BizException("验证未通过,用户不存在");
        } catch (LockedAccountException lae) {
            token.clear();
            throw new BizException("验证未通过,账户已锁定");
        } catch (ExcessiveAttemptsException e) {
            token.clear();
            throw new BizException("验证未通过,错误次数过多");
        } catch (AuthenticationException e) {
            token.clear();
            throw new BizException("密码错误");
        }
    }
}
