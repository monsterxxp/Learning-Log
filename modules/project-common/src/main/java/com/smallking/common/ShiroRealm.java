package com.smallking.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class ShiroRealm extends AuthorizingRealm {

//    @Autowired
//    protected IUserService userService;
//
//    @Autowired
//    protected IRoleService roleService;
//
//    @Autowired
//    protected IPermissionService permissionService;
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
        String principal = (String)token.getPrincipal();
//        User user = Optional.ofNullable(userService.getByUserName(principal)).orElseThrow(UnknownAccountException::new);
//        if (user.getUserStatus().equals('0')) {
//            throw new LockedAccountException();
//        }
        // 从数据库查询出来的账号名和密码,与用户输入的账号和密码对比
        // 当用户执行登录时,在方法处理上要实现 user.login(token)
        // 然后会自动进入这个类进行认证
        // 交给 AuthenticatingRealm 使用 CredentialsMatcher 进行密码匹配，如果觉得人家的不好可以自定义实现
        // TODO 如果使用 HashedCredentialsMatcher 这里认证方式就要改一下 SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, "密码", ByteSource.Util.bytes("密码盐"), getName());
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, user.getUserPwd(), ByteSource.Util.bytes(user.getSalt()), getName());
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("USER_SESSION", user);
//        user.setLastLoginTime(new Date());
//        userService.updateById(user);
        return null;
    }

    /**
     * 只有需要验证权限时才会调用, 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.在配有缓存的情况下，只加载一次.
     * 如果需要动态权限,但是又不想每次去数据库校验,可以存在ehcache中.自行完善
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
//        Session session = SecurityUtils.getSubject().getSession();
//        Object user =  session.getAttribute("USER_SESSION");
//        JSONObject json = JSONUtil.parseObj(user);
//        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        // 用户的角色集合
//        List<Role> roles = roleService.getRolesByUserId(Integer.valueOf(json.get("userId").toString()));
//        Set<String> rolesByString = new HashSet<>();
//        roles.forEach(e -> {
//            rolesByString.add(e.getRoleName());
//        });
//        info.setRoles(rolesByString);
//
//        // 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面可以不要
//        // 只有角色并没有颗粒度到每一个按钮 或 是操作选项  PERMISSIONS 是可选项
//        List<Permission> permissions = permissionService.getPermissionsByRoleIds(roles.stream().map(e -> e.getRoleId()).collect(Collectors.toList()));
//        Set<String> permissionByString = new HashSet<>();
//        permissions.forEach(e -> {
//            permissionByString.add(e.getPermissionCode());
//        });
//        info.addStringPermissions(permissionByString);
        return null;
    }
}
