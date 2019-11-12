package com.smallking.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.common.BizException;
import com.smallking.dao.SysUserDAO;
import com.smallking.enums.StatusEnum;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import com.smallking.service.impl.repository.SysUserRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public SysUser findByAccount(String account) {
        return sysUserDAO.findByAccount(account);
    }

    @Override
    public IPage findPage(Page pageable, SysUser sysUser) {
        return sysUserDAO.findPage(pageable, sysUser);
    }

    @Override
    public SysUser create(SysUser entity) {
        SysUser searchUser = sysUserDAO.findByAccount(entity.getAccount());
        if (searchUser != null) {
            throw new BizException("用户名已存在，请检查");
        }
        String defaultPassword = "111111";

        defaultPassword = DigestUtil.md5Hex(defaultPassword);
        //生成盐值
        String salt = RandomUtil.simpleUUID();

        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        //密码加上盐值再进行加密
        String password = new SimpleHash("MD5", defaultPassword,credentialsSalt,1024).toString();
        entity.setSalt(salt);
        entity.setPassword(password);
        entity.setStatus(StatusEnum.ENABLE.toString());
        SysUser sysUser = sysUserRepository.save(entity);
        return sysUserDAO.selectById(sysUser.getId());
    }

}
