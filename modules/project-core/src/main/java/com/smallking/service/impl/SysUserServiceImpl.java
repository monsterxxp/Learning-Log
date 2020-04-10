package com.smallking.service.impl;

import cn.hutool.core.collection.CollectionUtil;
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
import com.smallking.model.*;
import com.smallking.dto.SysUserDTO;
import com.smallking.service.ISysMenuService;
import com.smallking.service.ISysRoleRelationService;
import com.smallking.service.ISysUserService;
import com.smallking.repository.SysUserRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private ISysRoleRelationService sysRoleRelationService;

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
        SysUserDTO sysUserDTO = sysUserDAO.findDTOById(id);
        // 获取关联角色
        List<SysRoleRelation> sysRoleRelations = sysRoleRelationService.findByUserId(id);
        if (CollectionUtil.isNotEmpty(sysRoleRelations)) {
            sysUserDTO.setRoleIds(sysRoleRelations.stream().map(e -> e.getRoleId()).collect(Collectors.toList()));
        } else {
            sysUserDTO.setRoleIds(new ArrayList<>());
        }
        return sysUserDTO;
    }

    @Override
    @Transactional
    public SysUserDTO update(SysUserDTO sysUserDTO) throws Exception {
        String password = sysUserRepository.getOne(sysUserDTO.getId()).getPassword();
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
        sysUser.setPassword(password);
        sysUser = sysUserRepository.saveAndFlush(sysUser);
        if (sysUserDTO.getRoleIds() != null) {
            // 删除角色关联并重新关联角色
            sysRoleRelationService.deleteByUserId(sysUser.getId());
            List<SysRoleRelation> sysRoleRelations = new ArrayList<>();
            for (String roleId : sysUserDTO.getRoleIds()) {
                SysRoleRelation sysRoleRelation = new SysRoleRelation();
                sysRoleRelation.setRoleId(roleId);
                sysRoleRelation.setUserId(sysUser.getId());
                sysRoleRelations.add(sysRoleRelation);
            }
            sysRoleRelationService.batchSysRoleRelation(sysRoleRelations);
        }
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
        // 获取菜单权限信息
        List<SysMenuDTO> menuList =  sysMenuService.findMenuByUserId(user.getId());
        return sysUserInfo;
    }

    @Override
    public JSONArray findNav(String token) throws Exception {
        Session session = SecurityUtils.getSubject().getSession();
        SysUser user = (SysUser) session.getAttribute("USER_SESSION");
        List<SysMenuDTO> menus = sysMenuService.findMenuByUserId(user.getId());
        List<SysMenuDTO> rootMenus = menus.stream().filter(e -> "0".equals(e.getParentId())).collect(Collectors.toList());
        JSONArray indexChild = initMenu(rootMenus, menus);
        JSONObject index = new JSONObject();
        index.put("title", "首页");
        index.put("key", "");
        index.put("name", "index");
        index.put("component", "BasicLayout");
        index.put("redirect", "/dashboard/workplace");
        index.put("children", indexChild);

        JSONArray menuData = new JSONArray();
        menuData.add(index);
        return menuData;
    }

    private JSONArray initMenu(List<SysMenuDTO> rootMenus, List<SysMenuDTO> menus) {
        JSONArray jsonArray = new JSONArray();
        if (CollectionUtil.isNotEmpty(rootMenus))
        for (SysMenuDTO sysMenuDTO : rootMenus) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", sysMenuDTO.getName());
            if ("0".equals(sysMenuDTO.getIsFrame())) {
                jsonObject.put("key", sysMenuDTO.getMenuUrl());
            } else {
                jsonObject.put("path", sysMenuDTO.getMenuUrl());
            }
            if ("0".equals(sysMenuDTO.getIsFrame()) && !"3".equals(sysMenuDTO.getMenuType())) {
                jsonObject.put("component", sysMenuDTO.getComponent());
            }
            if (StringUtils.isNotEmpty(sysMenuDTO.getIcon())) {
                jsonObject.put("icon", sysMenuDTO.getIcon());
            }
            if (!"3".equals(sysMenuDTO.getMenuType())) {
                if ("1".equals(sysMenuDTO.getIsFrame())) {
                    jsonObject.put("target", "_blank");
                }
                if ("1".equals(sysMenuDTO.getIsHidden())) {
                    jsonObject.put("show", true);
                } else {
                    jsonObject.put("show", false);
                }
            }
            // 获取子菜单
            List<SysMenuDTO> children = menus.stream().filter(e -> e.getParentId().equals(sysMenuDTO.getId()) && !"3".equals(e.getMenuType())).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(children)) {
                // 存在子菜单
                JSONArray childrenJsonArr = initMenu(children, menus);
                jsonObject.put("children", childrenJsonArr);
            }
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    @Override
    public List<SysUser> findUserList() {
        return sysUserDAO.findAll();
    }

}
