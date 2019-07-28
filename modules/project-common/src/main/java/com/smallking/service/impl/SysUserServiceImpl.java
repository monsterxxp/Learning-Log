package com.smallking.service.impl;

import com.smallking.dao.SysUserDao;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import com.smallking.service.impl.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @program: learn
 * @description: 系统用户接口实现类
 * @author: smallking
 * @data: 2019-07-27 01:47
 **/
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    @Override
    public List<SysUser> findAllByJPA() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser create() {
        SysUser user = new SysUser();
        user.setAccount("123");
        user.setName("12312");
        user.setPassword("1123");
        SysUser sysUser = sysUserRepository.saveAndFlush(user);
        return sysUser;
    }

    @Override
    public SysUser update(String id) {
        SysUser user = sysUserRepository.findById(id).get();
        user.setName("321");
        SysUser result = sysUserRepository.saveAndFlush(user);
        return result;
    }
}
