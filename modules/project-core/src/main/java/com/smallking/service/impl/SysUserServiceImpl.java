package com.smallking.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.dao.SysUserDAO;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import com.smallking.service.impl.repository.SysUserRepository;
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
    private SysUserDAO sysUserDao;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser findByAccount(String account) {
        return sysUserDao.findByAccount(account);
    }

    @Override
    public IPage findPage(Page pageable, SysUser sysUser) {
        return sysUserDao.findPage(pageable, sysUser);
    }
}
