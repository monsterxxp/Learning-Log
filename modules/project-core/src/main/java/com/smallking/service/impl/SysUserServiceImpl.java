package com.smallking.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.common.BizException;
import com.smallking.dao.SysUserDAO;
import com.smallking.dto.SysMenuDTO;
import com.smallking.dto.SysRoleDTO;
import com.smallking.enums.StatusEnum;
import com.smallking.listener.DeleteListenable;
import com.smallking.model.SysPermission;
import com.smallking.model.SysUser;
import com.smallking.dto.SysUserDTO;
import com.smallking.model.SysUserInfo;
import com.smallking.service.ISysMenuService;
import com.smallking.service.ISysUserService;
import com.smallking.repository.SysUserRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @program: learn
 * @description: 系统用户接口实现类
 * @author: smallking
 * @data: 2019-07-27 01:47
 **/
@Service("sysUserService")
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserDAO sysUserDAO;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private ISysMenuService sysMenuService;

    @Override
    public SysUserDTO findByAccount(String account) {
        return sysUserDAO.findByAccount(account);
    }

    @Override
    public IPage findPage(Page pageable, SysUserDTO sysUserDTO) {
        return sysUserDAO.findPage(pageable, sysUserDTO);
    }

    @Override
    public SysUserDTO create(SysUserDTO sysUserDTO) throws Exception {
        SysUser searchUser = sysUserDAO.findByAccount(sysUserDTO.getAccount());
        if (searchUser != null) {
            throw new BizException("用户名已存在，请检查");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        String defaultPassword = "111111";
        defaultPassword = DigestUtil.md5Hex(defaultPassword);
        //生成盐值
        String salt = RandomUtil.simpleUUID();
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        //密码加上盐值再进行加密
        String password = new SimpleHash("MD5", defaultPassword,credentialsSalt,1024).toString();
        sysUser.setSalt(salt);
        sysUser.setPassword(password);
        sysUser.setStatus(StatusEnum.ENABLE.toString());
        sysUser.setUserStatus(StatusEnum.ENABLE.toString());
        sysUser = sysUserRepository.saveAndFlush(sysUser);
        return sysUserDAO.findDTOById(sysUser.getId());
    }

    @Override
    public SysUserDTO findDTOById(String id) {
        return sysUserDAO.findDTOById(id);
    }

    @Override
    public SysUserDTO update(SysUserDTO sysUserDTO) throws Exception {
        String password = sysUserRepository.getOne(sysUserDTO.getId()).getPassword();
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        sysUser.setPassword(password);
        sysUser = sysUserRepository.saveAndFlush(sysUser);
        return sysUserDAO.findDTOById(sysUser.getId());
    }

    @Override
    public void deleteById(String id) throws Exception {
        SysUser sysUser = sysUserDAO.selectById(id);
        if (sysUser instanceof DeleteListenable) {
            sysUser.setStatus(StatusEnum.DELETED.toString());
            sysUserRepository.save(sysUser);
        } else {
            sysUserRepository.deleteById(id);
        }
    }

    @Override
    public SysUserDTO resetPwd(SysUserDTO sysUserDTO) throws Exception {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        String defaultPassword = "111111";
        defaultPassword = DigestUtil.md5Hex(defaultPassword);
        //生成盐值
        String salt = RandomUtil.simpleUUID();
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        //密码加上盐值再进行加密
        String password = new SimpleHash("MD5", defaultPassword,credentialsSalt,1024).toString();
        sysUser.setSalt(salt);
        sysUser.setPassword(password);
        sysUser = sysUserRepository.save(sysUser);
        return sysUserDAO.findDTOById(sysUser.getId());
    }

    @Override
    public void batchBulk(List<String> ids) throws Exception{
        List<SysUser> userList = sysUserDAO.selectBatchIds(ids);
        if (new SysUser() instanceof DeleteListenable) {
            userList.forEach(user -> {
                user.setStatus(StatusEnum.DELETED.toString());
            });
            sysUserRepository.saveAll(userList);
        } else {
            sysUserRepository.deleteInBatch(userList);
        }
    }

    @Override
    public SysUserInfo findUserInfo() throws Exception{
        SysUserInfo sysUserInfo = new SysUserInfo();
        // 获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser) session.getAttribute("USER_SESSION");
        BeanUtils.copyProperties(sysUserInfo, user);
        SysRoleDTO sysRoleDTO = new SysRoleDTO();
        sysRoleDTO.setId("1");

        List<SysPermission> permissions = new ArrayList<>();
        SysPermission permission = new SysPermission();
        permission.setId("123213");
        permissions.add(permission);
        sysRoleDTO.setPermissions(permissions);

        sysUserInfo.setRole(sysRoleDTO);
        // 获取菜单权限信息
        List<SysMenuDTO> menuList =  sysMenuService.findMenuByUserId(user.getId());
        return sysUserInfo;
    }

    @Override
    public JSONArray findNav(String token) throws Exception {
        JSONObject json = new JSONObject();
        json.put("title", "首页");
        json.put("key", "");
        json.put("name", "index");
        json.put("component", "BasicLayout");
        json.put("redirect", "/dashboard/workplace");


        JSONObject json2 = new JSONObject();
        json2.put("title", "仪表盘");
        json2.put("key", "dashboard");
        json2.put("component", "RouteView");
        json2.put("icon", "dashboard");
        JSONArray yibiaos = new JSONArray();
        JSONObject yibiao1 = new JSONObject();
        yibiao1.put("title", "分析页");
        yibiao1.put("key", "analysis");
        yibiao1.put("component", "Analysis");
        yibiao1.put("icon", "");
        JSONObject yibiao2 = new JSONObject();
        yibiao2.put("title", "监控页");
        yibiao2.put("key", "monitor");
        yibiao2.put("component", "Monitor");
        yibiao2.put("icon", "");
        JSONObject yibiao3 = new JSONObject();
        yibiao3.put("title", "工作台");
        yibiao3.put("key", "workplace");
        yibiao3.put("component", "Workplace");
        yibiao3.put("icon", "");
        yibiaos.add(yibiao1);
        yibiaos.add(yibiao2);
        yibiaos.add(yibiao3);
        json2.put("children", yibiaos);

        JSONObject json3 = new JSONObject();
        json3.put("title", "系统管理");
        json3.put("key", "system");
        json3.put("component", "PageView");
        json3.put("icon", "setting");
        JSONArray xitongs = new JSONArray();
//        JSONObject xitong1 = new JSONObject();
//        xitong1.put("title", "用户管理");
//        xitong1.put("key", "userList");
//        xitong1.put("icon", "");
//        JSONObject xitong2 = new JSONObject();
//        xitong2.put("title", "角色管理");
//        xitong2.put("key", "roleList");
//        xitong2.put("icon", "");
        JSONObject xitong3 = new JSONObject();
        xitong3.put("title", "用户管理");
        xitong3.put("key", "user-manage");
        xitong3.put("component", "UserManage");
        xitong3.put("icon", "");
//        xitongs.add(xitong1);
//        xitongs.add(xitong2);
        xitongs.add(xitong3);
        json3.put("children", xitongs);

        JSONArray arr = new JSONArray();
        arr.add(json2);
        arr.add(json3);
        json.put("children", arr);

        JSONArray arr2 = new JSONArray();
        arr2.add(json);
        return arr2;
    }

}
