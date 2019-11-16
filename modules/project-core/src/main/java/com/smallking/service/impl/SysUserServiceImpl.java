package com.smallking.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.common.BizException;
import com.smallking.dao.SysUserDAO;
import com.smallking.enums.StatusEnum;
import com.smallking.listener.DeleteListenable;
import com.smallking.model.SysUser;
import com.smallking.dto.SysUserDTO;
import com.smallking.service.ISysUserService;
import com.smallking.repository.SysUserRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUser, sysUserDTO);
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

}
