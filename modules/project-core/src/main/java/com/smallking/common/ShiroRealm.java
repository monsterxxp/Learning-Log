package com.smallking.common;

import com.smallking.dao.SysPermissionDAO;
import com.smallking.dao.SysRoleDAO;
import com.smallking.model.SysPermission;
import com.smallking.model.SysRole;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    protected ISysUserService sysUserService;

    @Autowired
    protected SysRoleDAO sysRoleDao;

    @Autowired
    protected SysPermissionDAO sysPermissionDao;
    /**
     * 认证回调函数,登录时调用
     * 首先根据传入的用户名获取User信息；然后如果user为空，那么抛出没找到帐号异常UnknownAccountException；
     * 如果user找到但锁定了抛出锁定异常LockedAccountException；最后生成AuthenticationInfo信息，
     * 交给间接父类AuthenticatingRealm使用CredentialsMatcher进行判断密码是否匹配，
     * 如果不匹配将抛出密码错误异常IncorrectCredentialsException；
     * 另外如果密码重试此处太多将抛出超出重试次数异常ExcessiveAttemptsException；
     * 在组装SimpleAuthenticationInfo信息时， 需要传入：身份信息（用户名）、凭据（密文密码）、盐（username+salt），
     * CredentialsMatcher使用盐加密传入的明文密码和此处的密文密码进行匹配。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        // 获取用户输入的用户名和密码
        String userName = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");

        // 通过用户名到数据库查询用户信息
        SysUser user = sysUserService.findByAccount(userName);

        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(user.getPassword())) {
            System.out.println(password + ":" + user.getPassword());
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }

    /**
     * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
     * 如果需要动态权限,但是又不想每次去数据库校验,可以存在ehcache中.自行完善
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        String account = user.getAccount();

        System.out.println("用户" + account + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        List<SysRole> roleList = sysRoleDao.findByAccount(account);
        Set<String> roleSet = new HashSet<>();
        for (SysRole r : roleList) {
            roleSet.add(r.getCode());
        }
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<SysPermission> permissionList = sysPermissionDao.findByAccount(account);
        Set<String> permissionSet = new HashSet<>();
        for (SysPermission p : permissionList) {
            permissionSet.add(p.getCode());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }
}
